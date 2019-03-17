package controller;

import dao.UserCredentialsDAO;
import dao.UserDAO;
import entity.User;
import entity.UserCredentials;
import service.UserCredentialsService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    UserCredentialsDAO userCredentialsDAO = new UserCredentialsService();
    UserDAO userDAO = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (availabilityChecker(login)) {
            userCredentialsDAO.add(new UserCredentials(login, password));
            userDAO.add(new User(), userCredentialsDAO.getUserCredentials(login).getId());

            resp.sendRedirect("/MoviesChecklistEE_war_exploded/login");
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/registration.html");
            requestDispatcher.forward(req, resp);
        }

    }

    private boolean availabilityChecker(String login) {
        boolean isAvailable = false;

        if (userCredentialsDAO.getUserCredentials(login) == null) {
            isAvailable = true;
        }

        return isAvailable;
    }
}
