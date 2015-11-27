package com.springapp.dao;

import com.springapp.command.UserInforCommand;
import com.springapp.entities.User;
import org.springframework.data.domain.Pageable;

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
    List<UserInforCommand> getAllUserInfor(Pageable pageable);

    /**
     * get size total user information
     *
     * @return size total user infor
     */
    int getSizeTotalUserInfor();

}
