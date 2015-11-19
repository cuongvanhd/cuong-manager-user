package com.springapp.services.impl;

import com.springapp.dao.GroupDao;
import com.springapp.entities.Group;
import com.springapp.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
@Service("groupService")
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupDao groupDao;

    @Transactional
    public List<Group> getAllGroup() {
        return groupDao.getAllGroup();
    }
}
