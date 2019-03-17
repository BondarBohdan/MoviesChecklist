package controller;

import dao.MovieDAO;
import entity.Movie;
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
    MovieDAO movieDAO = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("userCredentials") == null) {
            resp.sendRedirect("/MoviesChecklistEE_war_exploded/login");
        } else {
            List<Movie> movieList = movieDAO.getAll();

            req.setAttribute("movies", movieList);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/library.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}

