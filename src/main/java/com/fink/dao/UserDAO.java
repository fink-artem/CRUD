package com.fink.dao;

import com.fink.model.User;
import java.util.List;

public interface UserDAO {

    public String persistUser(User user);

    public void deleteUser(User user);
    
    public void deleteUserByLogin(String login);

    public List<User> getUsersList();

    public String updateUser(User user);
    
    public String editUser(User user);
}
