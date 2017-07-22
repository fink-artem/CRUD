package com.fink.service;

import com.fink.dao.UserDAO;
import com.fink.model.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDao;

    @Override
    @Transactional
    public String persistUser(User user) {
        return userDao.persistUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }
    
    @Override
    @Transactional
    public void deleteUserByLogin(String login) {
        userDao.deleteUserByLogin(login);
    }

    @Override
    @Transactional
    public String updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    @Transactional
    public String editUser(User user) {
        return userDao.editUser(user);
    }
    
}
