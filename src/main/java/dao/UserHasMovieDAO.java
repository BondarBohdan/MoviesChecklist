package dao;

import entity.UserHasMovie;

import java.util.List;

public interface UserHasMovieDAO {

    void add(UserHasMovie userHasMovie);

    List<UserHasMovie> getAll();

    List<UserHasMovie> getByUserId(int userId);

    void update(UserHasMovie userHasMovie);

    void remove(UserHasMovie userHasMovie);
}
