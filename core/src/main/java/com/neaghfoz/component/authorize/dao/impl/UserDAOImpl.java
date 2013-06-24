package com.neaghfoz.component.authorize.dao.impl;

import com.neaghfoz.component.authorize.dao.IUserDAO;
import com.neaghfoz.component.authorize.model.User;
import com.neaghfoz.framework.hibernate.BaseDAOImpl;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: btxhuman
 * Date: 13-5-4
 * Time: 下午8:12
 * To change this template use File | Settings | File Templates.
 */
public class UserDAOImpl extends BaseDAOImpl<User> implements IUserDAO {

    @Override
    public User findUserByUserName(String userName) {
        Session session = getSession();
        User user = (User) session.createQuery("from User u where u.userName = :userName").setParameter("userName",userName).uniqueResult();
        return user;
        /*List users = getSession().createCriteria(User.class).add(Restrictions.eq("username", username)).list();
        if (users == null || users.isEmpty()) {
            throw new UsernameNotFoundException("user '" + username + "' not found...");
        } else {
            return (UserDetails) users.get(0);
        }*/

    }
}
