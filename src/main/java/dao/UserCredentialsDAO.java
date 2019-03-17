package dao;

import entity.UserCredentials;

import java.sql.SQLException;
import java.util.List;

public interface UserCredentialsDAO {

    void add(UserCredentials userCredentials);

    List<UserCredentials> getAll();

    UserCredentials getById(int id);

    UserCredentials getUserCredentials(String login);

    UserCredentials getUserCredentials(String login, String password);

    void updatePassword(UserCredentials userCredentials);

    void remove(UserCredentials userCredentials);
}
