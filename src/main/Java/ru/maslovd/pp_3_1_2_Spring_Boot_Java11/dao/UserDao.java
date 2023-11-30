package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.dao;

import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(Long id);

    User getUserByID(long id);

    void updateUser(long id, String newName, String newLastName, String newEmail);

}
