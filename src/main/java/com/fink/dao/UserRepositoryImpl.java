package com.fink.dao;

import com.fink.model.User;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param user user which will be added to the database
     */
    @Override
    public void persistUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    /**
     *
     * @return list of users
     */
    @Override
    public List<User> getUsersList() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }
    
    /**
     *
     * @param login login of user
     * @return user
     */
    @Override
    public User getUserByLogin(String login) {
        return (User)sessionFactory.getCurrentSession().get(User.class, login);
    }

    /**
     *
     * @param user user which will be deleted in the database
     */
    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

    /**
     *
     * @param user user which will be updated in the database
     */
    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
    }

}
