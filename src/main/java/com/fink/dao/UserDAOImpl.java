package com.fink.dao;

import com.fink.model.User;
import java.util.List;
import javax.faces.context.FacesContext;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     *
     * @param user user which will be added to the database
     * @return jump link
     */
    public String persistUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
        return "index.xhtml?faces-redirect=true";
    }

    /**
     *
     * @return list of users
     */
    public List<User> getUsersList() {
        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    /**
     *
     * @param user user which will be deleted in the database
     */
    public void deleteUser(User user) {
        deleteUserByLogin(user.getLogin());
    }

    /**
     *
     * @param login login of user which will be deleted in the database
     */
    public void deleteUserByLogin(String login) {
        User u = (User) sessionFactory.getCurrentSession().load(User.class, login);
        sessionFactory.getCurrentSession().delete(u);
    }

    /**
     *
     * @param user user which will be updated in the database
     * @return // jump link
     */
    public String updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return "index.xhtml?faces-redirect=true";
    }

    /**
     * Method for loading context
     *
     * @param user user which will be updated in the database
     * @return // jump link
     */
    public String editUser(User user) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User where login=:login");// get information about user with login
        query.setParameter("login", user.getLogin());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("editUser", (User) query.uniqueResult());//update context on page of editing user 
        return "edit.xhtml?faces-redirect=true";
    }

}
