package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.service;

import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsersList();

    void addUser(User user);

    void deleteUser(Long id);

    User getUserByID(long id);

    void updateUser(long id, String newName, String newLastName, String newEmail);
}
