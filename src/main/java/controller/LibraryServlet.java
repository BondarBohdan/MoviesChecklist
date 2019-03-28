package controller;

import constant.PageURL;
import dao.MovieDAO;
import entity.Movie;
import entity.UserCredentials;
import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/library")
public class LibraryServlet extends HttpServlet {
    private MovieDAO movieDAO = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserCredentials userCredentials = null;

        List<Movie> movieList = movieDAO.getAll();

        req.setAttribute("movies", movieList);

        HttpSession session = req.getSession();
        if (session.getAttribute("userCredentials") != null) {
            userCredentials = (UserCredentials) session.getAttribute("userCredentials");

            if (userCredentials.isAdmin()) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.ADMIN_LIBRARY.getUrl());
                requestDispatcher.forward(req, resp);
                return;
            }

        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.LIBRARY.getUrl());
        requestDispatcher.forward(req, resp);

    }
}

