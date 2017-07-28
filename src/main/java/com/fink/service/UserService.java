package com.fink.service;

import com.fink.model.User;
import java.util.List;

public interface UserService {

    public void persistUser(User user);

    public List<User> getUsersList();
    
    public User getUserByLogin(String login);

    public void deleteUser(User user);
    
    public void deleteUserByLogin(String login);

    public void updateUser(User user);
    
    public boolean checkLogin(String login);
    
}
