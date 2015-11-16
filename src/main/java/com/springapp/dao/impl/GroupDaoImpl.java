package com.springapp.dao.impl;

import com.springapp.dao.GroupDao;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.security.acl.Group;
import java.util.List;

/**
 * Created by Cuong on 2015/11/16.
 */
public class GroupDaoImpl extends BaseDaoImpl<Group, Integer> implements GroupDao {

    public GroupDaoImpl() {
        super(Group.class);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Group> getAllGroup() {

        return null;
    }
}
