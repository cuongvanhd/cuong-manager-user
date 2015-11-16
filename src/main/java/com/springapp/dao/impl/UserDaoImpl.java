package com.springapp.dao.impl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Cuong on 2015/11/13.
 */
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, Integer> implements UserDao {

    public UserDaoImpl() {
        super(User.class);
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public User getUserByLoginName(String loginName) {
        StringBuilder hql = new StringBuilder();
        hql.append(" FROM User user ");
        hql.append(" INNER JOIN user.mainGroup mainGroup ");
        hql.append(" ON user.groupId = mainGroup.groupId ");
        hql.append(" WHERE user.loginName like '%" + loginName + "%' ");

        Query query = getSession().createQuery(hql.toString());
        query.setParameter("loginName", loginName);

        return (User) query.uniqueResult();
    }
}
