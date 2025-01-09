package com.example.Dao;

import com.example.Entity.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public class UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public boolean addUser(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            Criteria criteria = session.createCriteria(User.class);

            session.saveOrUpdate(new User(username, password));
            return true;

        } finally {
            session.close();
        }


    }

    public boolean userLogin(User user) {
        Session session = sessionFactory.openSession();
        try{

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("username", user.getUserName()));
            criteria.add(Restrictions.eq("password", user.getPassword()));
            return true;
        }finally {
        session.close();
        }

    }
}
