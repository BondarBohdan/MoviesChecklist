package dao;

import entity.UserHasMovie;

import java.util.List;

public interface UserHasMovieDAO {

    void add(int userId, int movieId);

    List<UserHasMovie> getAll();

    List<UserHasMovie> getByUserId(int userId);

    void update(int userId, int movieId, boolean isWatched);

    void remove(int userId, int movieId);

    boolean existenceChecker(int userId, int movieId);
}
