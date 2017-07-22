package com.fink.controller;

import com.fink.model.User;
import com.fink.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Admin
 * Class of processing rest
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 
     * @return list of users
     */
    @RequestMapping(value = "/user", method = RequestMethod.GET, headers = "Accept=application/json")
    public List<User> getUsers() {
        return userService.getUsersList();
    }

    /**
     * 
     * @param user user which will be added to the database
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST, headers = "Accept=application/json")
    public void addUser(@RequestBody User user) {
        userService.persistUser(user);
    }

    /**
     * 
     * @param user user which will be updated in the database
     */
    @RequestMapping(value = "/user", method = RequestMethod.PUT, headers = "Accept=application/json")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    /**
     * 
     * @param login login of user which will be deleted in the database
     */
    @RequestMapping(value = "/user/{login}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public void deleteUser(@PathVariable("login") String login) {
        userService.deleteUserByLogin(login);
    }
}
