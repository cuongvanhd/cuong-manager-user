package com.springapp.services;

import com.springapp.entities.UserDetailJapanese;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
public interface UserDetailJapaneseService {

    /**
     * get all detail user
     *
     * @return list user detail
     */
    List<UserDetailJapanese> getAllDetailUser();
}
