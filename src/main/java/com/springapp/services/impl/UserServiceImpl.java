package com.springapp.services.impl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import com.springapp.entities.UserDetailJapanese;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/13.
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Transactional
    public User getUserByLoginName(String loginName) {
        return userDao.getUserByLoginName(loginName);
    }

    @Transactional
    public boolean login(String loginName, String password) {
        User user = userDao.getUserByLoginName(loginName);
        if (user == null) {
            return false;
        }
        if (!user.getPassword().equals(password)) {
            return false;
        }
        return true;
    }

    @Override
    public List<UserDetailJapanese> getAllUserInfor() {
        return userDao.getAllUserInfor();
    }
}
