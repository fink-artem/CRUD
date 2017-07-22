package com.fink.service;

import com.fink.model.User;
import java.util.List;

public interface UserService {

    public String persistUser(User user);

    public List<User> getUsersList();

    public void deleteUser(User user);
    
    public void deleteUserByLogin(String login);

    public String updateUser(User user);
    
    public String editUser(User user);
}
