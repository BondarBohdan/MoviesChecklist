package dao;

import entity.Movie;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface MovieDAO {

    void add(Movie movie);

    List<Movie> getAll();

    Movie getByMovieId(int id);

    Map<Movie, Boolean> getByUserId(int userId);

    void update(Movie movie);

    void remove(int id);
}
