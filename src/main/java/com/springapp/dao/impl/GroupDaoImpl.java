package com.springapp.dao.impl;

import com.springapp.dao.GroupDao;
import com.springapp.entities.Group;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/16.
 */
@Repository("groupDao")
public class GroupDaoImpl extends BaseDaoImpl<Group, Integer> implements GroupDao {

    public GroupDaoImpl() {
        super(Group.class);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<Group> getAllGroup() {

        return getSession().createCriteria(Group.class).list();
    }
}
