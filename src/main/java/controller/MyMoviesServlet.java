package controller;

import constant.PageURL;
import dao.MovieDAO;
import dto.MovieDTO;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/myMovies")
public class MyMoviesServlet extends HttpServlet {
    private MovieDAO movieDAO = new MovieService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserCredentials user;
        List<MovieDTO> movieList = new ArrayList<>();

        user = (UserCredentials) session.getAttribute("userCredentials");

        Map<Movie, Boolean> movieMap = movieDAO.getByUserId(user.getId());

        for (Map.Entry<Movie, Boolean> entry : movieMap.entrySet()) {
            movieList.add(new MovieDTO(entry.getKey().getId(), entry.getKey().getName(),
                    entry.getKey().getPosterUrl(), entry.getKey().getDescription(), entry.getValue()));
        }

        req.setAttribute("movies", movieList);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(PageURL.MY_MOVIES.getUrl());
        requestDispatcher.forward(req, resp);
    }
}
