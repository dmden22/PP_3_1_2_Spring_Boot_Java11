package ru.maslovd.pp_3_1_2_Spring_Boot_Java11.dao;

import javax.persistence.*;
import org.springframework.stereotype.Repository;
import ru.maslovd.pp_3_1_2_Spring_Boot_Java11.model.User;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery(
                "select u from User u", User.class
        ).getResultList();
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUser(Long id) {
        entityManager.remove(getUserByID(id));
    }

    @Override
    public User getUserByID(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(long id, String newName, String newLastName, String newEmail) {
        User user = getUserByID(id);
        if (user != null) {
            user.setName(newName);
            user.setLastName(newLastName);
            user.setEmail(newEmail);
        }
    }
}
