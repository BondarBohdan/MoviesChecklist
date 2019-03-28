package service;

import connection.Connector;
import dao.MovieDAO;
import entity.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MovieService extends Connector implements MovieDAO {

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
    public Map<Movie, Boolean> getByUserId(int userId) {
        Map<Movie, Boolean> movieList = new LinkedHashMap<>();

        String sql = "SELECT id, name, poster_url, description, is_watched FROM movie JOIN user_has_movie ON movie.id = user_has_movie.movie_id WHERE user_id =?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Movie movie = new Movie();
                movie.setId(resultSet.getInt("id"));
                movie.setName(resultSet.getString("name"));
                movie.setPosterUrl(resultSet.getString("poster_url"));
                movie.setDescription(resultSet.getString("description"));
                Boolean isWatched = resultSet.getBoolean("is_watched");

                movieList.put(movie, isWatched);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return movieList;
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> movieList = new ArrayList<>();

        String sql = "SELECT id, name, poster_url, description FROM movie ORDER BY id DESC";

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
        String sql = "SELECT * FROM MOVIE WHERE ID=?";

        Movie movie = new Movie();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();

            movie.setId(resultSet.getInt("id"));
            movie.setName(resultSet.getString("name"));
            movie.setPosterUrl(resultSet.getString("poster_url"));
            movie.setDescription(resultSet.getString("description"));

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
    public void remove(int id) {

        String sql = "DELETE FROM movie WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
