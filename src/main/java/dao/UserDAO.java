package dao;

import entity.User;

import java.util.List;

public interface UserDAO {

    void add(User user, int userCredentialsId);

    List<User> getAll();

    User getById(int id);

    void update(User user);

    void remove(User user);
}
