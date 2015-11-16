package com.springapp.services;

import com.springapp.entities.User;

/**
 * Created by Cuong on 2015/11/13.
 */
public interface UserService {

    /**
     * Get user by login name
     *
     * @param loginName
     * @return User
     */
    User getUserByLoginName(String loginName);

    /**
     * check login
     *
     * @param loginName
     * @param password
     * @return true if login is successful, false if login isn't successful
     */
    boolean login(String loginName, String password);
}
