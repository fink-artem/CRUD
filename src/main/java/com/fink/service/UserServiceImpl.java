package com.fink.service;

import com.fink.dao.UserRepository;
import com.fink.model.User;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public void persistUser(User user) {
        userRepository.persistUser(user);
    }

    @Override
    @Transactional
    public List<User> getUsersList() {
        return userRepository.getUsersList();
    }

    @Override
    @Transactional
    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        userRepository.deleteUser(user);
    }

    @Override
    @Transactional
    public void deleteUserByLogin(String login) {
        User user = userRepository.getUserByLogin(login);
        userRepository.deleteUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

}
