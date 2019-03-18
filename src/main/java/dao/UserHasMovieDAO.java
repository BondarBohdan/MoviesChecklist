package dao;

import entity.UserHasMovie;

import java.util.List;

public interface UserHasMovieDAO {

    void add(int userId, int movieId);

    List<UserHasMovie> getAll();

    List<UserHasMovie> getByUserId(int userId);

    void update(UserHasMovie userHasMovie);

    void remove(int userId, int movieId);
}
