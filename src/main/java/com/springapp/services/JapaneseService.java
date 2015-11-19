package com.springapp.services;

import com.springapp.entities.Japanese;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
public interface JapaneseService {

    /**
     * Get all japanese
     *
     * @return list japan
     */
    List<Japanese> getAllJapanese();
}
