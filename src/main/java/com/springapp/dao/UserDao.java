package com.springapp.dao;

import com.springapp.entities.User;
import com.springapp.entities.UserDetailJapanese;

import java.util.List;

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

    /**
     * Get all user information from DB
     *
     * @return list user information
     */
    List<UserDetailJapanese> getAllUserInfor();

}
