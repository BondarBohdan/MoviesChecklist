package controller;

import constant.PageURL;
import constant.ServletURL;
import dao.UserCredentialsDAO;
import dao.UserDAO;
import entity.User;
import entity.UserCredentials;
import org.apache.commons.codec.digest.DigestUtils;
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
    private static final int MIN_LENGTH = 3;

    private UserCredentialsDAO userCredentialsDAO = new UserCredentialsService();
    private UserDAO userDAO = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.REGISTRATION.getUrl());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = DigestUtils.md2Hex(req.getParameter("password"));

        if (availabilityChecker(login) && validationChecker(login, password)) {
            userCredentialsDAO.add(new UserCredentials(login, password));
            userDAO.add(new User(), userCredentialsDAO.getUserCredentials(login).getId());

            resp.sendRedirect(ServletURL.LOG_IN.getUrl());
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.REGISTRATION.getUrl());
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

    private boolean validationChecker(String login, String password) {
        if ((login != null) && (login.length() >= MIN_LENGTH) &&
                (password != null) && (password.length() >= MIN_LENGTH)) {
            return true;
        } else {
            return false;
        }
    }
}
