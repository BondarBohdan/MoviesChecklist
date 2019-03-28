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

@WebServlet("/editMovie")
public class EditMovieServlet extends HttpServlet {
    private MovieDAO movieDAO = new MovieService();
    private Movie movie = new Movie();
    private String forwardParams = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        int movieId = Integer.parseInt(req.getParameter("id"));
        movie = movieDAO.getByMovieId(movieId);
        forwardParams = "?start=" + req.getParameter("start");

        req.setAttribute("movie", movie);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.EDIT_MOVIE.getUrl());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        movie.setName(req.getParameter("name"));
        movie.setPosterUrl(req.getParameter("poster_url"));
        movie.setDescription(req.getParameter("description"));

        movieDAO.update(movie);

        resp.sendRedirect(ServletURL.LIBRARY.getUrl() + forwardParams);
    }
}
