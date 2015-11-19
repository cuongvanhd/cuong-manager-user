package com.springapp.dao;


import com.springapp.entities.Group;

import java.util.List;

/**
 * Created by Cuong on 2015/11/16.
 */
public interface GroupDao extends BaseDao<Group, Integer> {

    /**
     * Get all Group from DB
     *
     * @return list group
     */
    List<Group> getAllGroup();



}
