package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.dao.UserDao;
import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsersList() {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByID(long id) {
        return userDao.getUserByID(id);
    }

    @Override
    @Transactional
    public void updateUser(long id, String newName, String newLastName, String newEmail) {
        userDao.updateUser(id, newName, newLastName, newEmail);
    }
}
