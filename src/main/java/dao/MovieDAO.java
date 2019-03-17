package dao;

import entity.Movie;

import java.sql.SQLException;
import java.util.List;

public interface MovieDAO {

    void add(Movie movie);

    List<Movie> getAll();

    Movie getByMovieId(int id);

    List<Movie> getByUserId(int userId);

    void update(Movie movie);

    void remove(Movie movie);
}
