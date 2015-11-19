package com.springapp.dao.impl;

import com.springapp.dao.JapaneseDao;
import com.springapp.entities.Japanese;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
@Repository("japaneseDao")
public class JapaneseDaoImpl extends BaseDaoImpl<Japanese, Integer> implements JapaneseDao {

    public JapaneseDaoImpl() {
        super(Japanese.class);
    }

    @Transactional
    public List<Japanese> getAllJapanese() {
        return getSession().createCriteria(Japanese.class).list();
    }
}
