package controller;

import dao.UserDAO;
import entity.User;
import entity.UserCredentials;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
    HttpSession session;
    UserDAO userDAO = new UserService();
    UserCredentials userCredentials;
    User user;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session = req.getSession();
        if (session.getAttribute("userCredentials") != null) {
            userCredentials = (UserCredentials) session.getAttribute("userCredentials");
            user = userDAO.getById(userCredentials.getId());

            req.setAttribute("user", user);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/settings.jsp");
            requestDispatcher.forward(req, resp);

        } else {
            resp.sendRedirect("/MoviesChecklistEE_war_exploded/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user.setName(req.getParameter("name"));
        user.setSurname(req.getParameter("surname"));
        user.setEmail(req.getParameter("email"));

        userDAO.update(user);

        resp.sendRedirect("/MoviesChecklistEE_war_exploded/settings");
    }
}
