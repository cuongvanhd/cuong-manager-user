package com.springapp.services.impl;

import com.springapp.dao.JapaneseDao;
import com.springapp.entities.Japanese;
import com.springapp.services.JapaneseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
@Service("japaneseService")
public class JapaneseServiceImpl implements JapaneseService {

    @Autowired
    private JapaneseDao japaneseDao;

    @Override
    public List<Japanese> getAllJapanese() {
        return japaneseDao.getAllJapanese();
    }
}
