package service;

import bl.Util;
import dao.MovieDAO;
import entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieService extends Util implements MovieDAO {

    Connection connection = getConnection();

    @Override
    public void add(Movie movie) {

        String sql = "INSERT INTO movie (name, poster_url, description) VALUES(?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getPosterUrl());
            preparedStatement.setString(3, movie.getDescription());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getByUserId(int userId) {
        List<Movie> movieList = new ArrayList<>();

        String sql = "SELECT id, name, poster_url, description FROM movie JOIN user_has_movie ON movie.id = user_has_movie.movie_id WHERE user_id =?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setName(resultSet.getString("name"));
                movie.setPosterUrl(resultSet.getString("poster_url"));
                movie.setDescription(resultSet.getString("description"));

                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movieList = new ArrayList<>();

        String sql = "SELECT id, name, poster_url, description FROM movie";

        try (Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setName(resultSet.getString("name"));
                movie.setPosterUrl(resultSet.getString("poster_url"));
                movie.setDescription(resultSet.getString("description"));

                movieList.add(movie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public Movie getByMovieId(int id) {
        String sql = "SELECT id, name, poster_url, description FROM MOVIE WHERE ID=?";

        Movie movie = new Movie();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            movie.setId(resultSet.getInt("id"));
            movie.setName(resultSet.getString("name"));
            movie.setPosterUrl(resultSet.getString("poster_url"));
            movie.setDescription(resultSet.getString("description"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movie;
    }

    @Override
    public void update(Movie movie) {
        String sql = "UPDATE movie SET name=?, poster_url=?, description=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setString(2, movie.getPosterUrl());
            preparedStatement.setString(3, movie.getDescription());
            preparedStatement.setInt(4, movie.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(Movie movie) {

        String sql = "DELETE FROM movie WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, movie.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
