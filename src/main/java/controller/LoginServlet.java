package controller;

import dao.UserCredentialsDAO;
import service.UserCredentialsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserCredentialsDAO userCredentialsDAO = new UserCredentialsService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (existenceChecker(login, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("userCredentials", userCredentialsDAO.getUserCredentials(login, password));

            resp.sendRedirect("/MoviesChecklistEE_war_exploded/mymovies");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
            requestDispatcher.forward(req, resp);
        }
    }

    private boolean existenceChecker(String login, String password) {
        boolean exists = false;

        if (userCredentialsDAO.getUserCredentials(login, password) != null) {
            exists = true;
        }

        return exists;
    }
}
