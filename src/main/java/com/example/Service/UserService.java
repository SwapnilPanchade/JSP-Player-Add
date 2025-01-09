package com.example.Service;

import com.example.Dao.UserDao;
import com.example.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public boolean addUser(String username, String password) {
        return userDao.addUser(username, password);
    }

    public boolean userLogin(User user) {
        return userDao.userLogin(user);
    }
}

