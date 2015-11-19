package com.springapp.services;

import com.springapp.entities.Group;

import java.util.List;

/**
 * Created by Cuong on 2015/11/16.
 */
public interface GroupService {

    /**
     * Get all Group from DB
     *
     * @return list group
     */
    List<Group> getAllGroup();
}
