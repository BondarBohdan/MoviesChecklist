package service;

import bl.Util;
import dao.UserHasMovieDAO;
import entity.UserHasMovie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserHasMovieService extends Util implements UserHasMovieDAO {
    Connection connection = getConnection();

    @Override
    public void add(UserHasMovie userHasMovie) {
        String sql = "INSERT INTO user_has_movie (user_id, movie_id) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userHasMovie.getUserId());
            preparedStatement.setInt(2, userHasMovie.getMovieId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserHasMovie> getAll() {
        List<UserHasMovie> userHasMovieList = new ArrayList<>();

        String sql = "SELECT user_id, movie_id FROM user_has_movie";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                UserHasMovie userHasMovie = new UserHasMovie();
                userHasMovie.setUserId(resultSet.getInt("user_id"));
                userHasMovie.setMovieId(resultSet.getInt("movie_id"));

                userHasMovieList.add(userHasMovie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userHasMovieList;
    }

    @Override
    public List<UserHasMovie> getByUserId(int userId) {
        List<UserHasMovie> userHasMovieList = new ArrayList<>();

        String sql = "SELECT user_id, movie_id FROM user_has_movie WHERE user_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserHasMovie userHasMovie = new UserHasMovie();
                userHasMovie.setUserId(userId);
                userHasMovie.setMovieId(resultSet.getInt("movie_id"));

                userHasMovieList.add(userHasMovie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userHasMovieList;
    }

    @Override
    public void update(UserHasMovie userHasMovie) {
        String sql = "UPDATE user_has_movie WHERE user_id=? AND movie_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userHasMovie.getUserId());
            preparedStatement.setInt(2, userHasMovie.getMovieId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(UserHasMovie userHasMovie) {
        String sql = "DELETE FROM user_has_movie WHERE user_id=? AND movie_id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, userHasMovie.getUserId());
            preparedStatement.setInt(2, userHasMovie.getMovieId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
