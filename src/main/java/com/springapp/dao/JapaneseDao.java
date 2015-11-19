package com.springapp.dao;

import com.springapp.entities.Japanese;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
public interface JapaneseDao extends BaseDao<Japanese, Integer> {

    /**
     * Get all japanese
     *
     * @return list japan
     */
    List<Japanese> getAllJapanese();
}
