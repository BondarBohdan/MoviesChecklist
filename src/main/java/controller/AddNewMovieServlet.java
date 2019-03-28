package controller;

import constant.PageURL;
import constant.ServletURL;
import dao.MovieDAO;
import entity.Movie;
import service.MovieService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNewMovie")
public class AddNewMovieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.ADD_MOVIE.getUrl());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        MovieDAO movieDAO = new MovieService();
        Movie movie = new Movie();
        movie.setName(req.getParameter("name"));
        movie.setPosterUrl(req.getParameter("poster_url"));
        movie.setDescription(req.getParameter("description"));

        movieDAO.add(movie);

        resp.sendRedirect(ServletURL.LIBRARY.getUrl());
    }
}
