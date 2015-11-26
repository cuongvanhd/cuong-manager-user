package com.springapp.services.impl;

import com.springapp.command.UserInforCommand;
import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import com.springapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public List<UserInforCommand> getAllUserInfor(Pageable pageable) {
        return userDao.getAllUserInfor(pageable);
    }

    @Override
    public List<User> getListUser() {
        return userDao.getListUser();
    }

}
