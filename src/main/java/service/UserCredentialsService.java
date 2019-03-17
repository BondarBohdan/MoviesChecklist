package service;

import bl.Util;
import dao.UserCredentialsDAO;
import entity.UserCredentials;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCredentialsService extends Util implements UserCredentialsDAO {
    Connection connection = getConnection();

    @Override
    public void add(UserCredentials userCredentials) {
        String sql = "INSERT INTO user_credentials (login, password) VALUES (?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, userCredentials.getLogin());
            preparedStatement.setString(2, userCredentials.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserCredentials> getAll() {
        List<UserCredentials> userCredentialsList = new ArrayList<>();

        String sql = "SELECT id, login, password FROM user_credentials";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                UserCredentials userCredentials = new UserCredentials();
                userCredentials.setId(resultSet.getInt("id"));
                userCredentials.setLogin(resultSet.getString("login"));
                userCredentials.setPassword(resultSet.getString("password"));

                userCredentialsList.add(userCredentials);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCredentialsList;
    }

    @Override
    public UserCredentials getById(int id) {

        String sql = "SELECT login, password FROM user_credentials WHERE id=?";

        UserCredentials userCredentials = new UserCredentials();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userCredentials.getId());

            ResultSet resultSet = preparedStatement.executeQuery();

            userCredentials.setId(resultSet.getInt("id"));
            userCredentials.setLogin(resultSet.getString("login"));
            userCredentials.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCredentials;
    }

    @Override
    public UserCredentials getUserCredentials(String login, String password) {
        String sql = "SELECT * FROM user_credentials WHERE login=? AND password=?";

        UserCredentials userCredentials = new UserCredentials();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userCredentials.setId(resultSet.getInt("id"));
                userCredentials.setLogin(resultSet.getString("login"));
                userCredentials.setPassword(resultSet.getString("password"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCredentials;
    }

    @Override
    public UserCredentials getUserCredentials(String login) {
        String sql = "SELECT * FROM user_credentials WHERE login=?";

        UserCredentials userCredentials = new UserCredentials();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userCredentials.setId(resultSet.getInt("id"));
                userCredentials.setLogin(resultSet.getString("login"));
                userCredentials.setPassword(resultSet.getString("password"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCredentials;
    }

    @Override
    public void updatePassword(UserCredentials userCredentials) {
        String sql = "UPDATE user_credentials SET password=? WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            preparedStatement.setString(1, userCredentials.getPassword());
            preparedStatement.setInt(2, userCredentials.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void remove(UserCredentials userCredentials) {
        String sql = "DELETE FROM user_credentials WHERE id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, userCredentials.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
