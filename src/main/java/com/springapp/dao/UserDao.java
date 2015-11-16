package com.springapp.dao;

import com.springapp.entities.User;

/**
 * Created by Cuong on 2015/11/13.
 */
public interface UserDao extends BaseDao<User, Integer> {

    /**
     * Get user by login name
     *
     * @param loginName
     * @return User
     */
    User getUserByLoginName(String loginName);
}
