package com.springapp.services.impl;

import com.springapp.dao.UserDetailJapaneseDao;
import com.springapp.entities.UserDetailJapanese;
import com.springapp.services.UserDetailJapaneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
@Service("userDetailJapaneseService")
public class UserDetailJapaneseServiceImpl implements UserDetailJapaneseService {

    @Autowired
    private UserDetailJapaneseDao userDetailJapaneseDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserDetailJapanese> getAllDetailUser() {
        return userDetailJapaneseDao.getAllDetailUser();
    }
}
