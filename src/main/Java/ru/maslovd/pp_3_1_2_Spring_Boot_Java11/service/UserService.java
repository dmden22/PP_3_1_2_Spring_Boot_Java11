package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.service;

import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;

import java.util.List;

public interface UserService {

    public List<User> getUsersList();

    public void addUser(User user);

    public void deleteUser(Long id);

    public User getUserByID(long id);

    public void updateUser(long id, String newName, String newLastName, String newEmail);
}
