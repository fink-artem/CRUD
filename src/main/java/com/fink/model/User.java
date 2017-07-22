package com.fink.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @author Admin
 * Model of table in database.
 * Required for interaction with the database.
 *
 */
@Entity
@Table(name = "app_user", catalog = "public")
public class User implements Serializable {

    @Id
    private String login;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    @Temporal(javax.persistence.TemporalType.DATE)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    private String about;
    private String address;

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

    @Override
    public String toString() {
        return login + ":" + password + ":" + name + ":" + surname + ":" + birthday + ":" + about + ":" + address;
    }

}
