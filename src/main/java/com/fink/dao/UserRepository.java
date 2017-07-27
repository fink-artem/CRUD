package com.fink.dao;

import com.fink.model.User;
import java.util.List;

public interface UserRepository{

    public void persistUser(User user);

    public List<User> getUsersList();

    public User getUserByLogin(String login);

    public void deleteUser(User user);

    public void updateUser(User user);

}
