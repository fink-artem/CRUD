package com.fink.beans;

import com.fink.model.User;
import com.fink.service.UserService;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * Bean for interaction with JSF
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class UserBean implements Serializable {

    @ManagedProperty(value = "#{userService}")
    UserService userService;

    private String login;
    private String password;
    private String name;
    private String surname;
    private Date birthday;
    private String about;
    private String address;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void deleteUser(User user) {
        userService.deleteUser(user);
    }

    public String updateUser(User user) {
        userService.updateUser(user);
        return "index.xhtml?faces-redirect=true";
    }

    public String persistUser() {
        User user = new User();
        user.setLogin(getLogin());
        user.setPassword(getPassword());
        user.setName(getName());
        user.setSurname(getSurname());
        user.setBirthday(getBirthday());
        user.setAbout(getAbout());
        user.setAddress(getAddress());
        try {
            userService.persistUser(user);
        } catch (DataIntegrityViolationException e) {
            return "";
        }
        return "index.xhtml?faces-redirect=true";
    }

    public String loadContext(User user) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editUser", user);//update context on page of editing user 
        return "edit.xhtml?faces-redirect=true";
    }

    public void validateLogin(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        if (userService.checkLogin((String)value)) {
            context.addMessage(null, new FacesMessage("Пользователь с таким логином уже существует"));
        }
    }

}
