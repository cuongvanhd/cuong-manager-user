package com.springapp.dao.impl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        hql.append(" from User user ");
        hql.append(" left join fetch user.mainGroup mainGroup ");
//        hql.append(" where user.loginName like '%" + loginName + "%' ");
        hql.append(" where user.loginName = :loginName ");

//        System.out.println(hql.toString());

        Query query = getSession().createQuery(hql.toString());
        query.setParameter("loginName", loginName);

//        List<User> list = query.list();
//        for(User user:list) {
//            System.out.println(user.getLoginName());
//        }

        return (User) query.uniqueResult();
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getAllUserInfor() {

        StringBuilder hql = new StringBuilder();
//        hql.append(" SELECT u.userId, f.groupName, u.fullName, u.fullNameKata, u.email, u.tel, u.birthday, g.nameLevel, g.startDate, g.endDate, g.total ");
//        hql.append(" FROM User u ");
//        hql.append(" INNER JOIN u.mainGroup k ");
//        hql.append(" ON u.mainGroup.groupId = k.groupId ");
//        hql.append(" LEFT JOIN( ");
//        hql.append(" SELECT d.userId, m.nameLevel, d.startDate, d.endDate, d.total ");
//        hql.append(" FROM Japanese m ");
//        hql.append(" INNER JOIN u.userDetailJapaneses d ");
//        hql.append(" ON m.codeLevel = d.codeLevel ");
//        hql.append(" ) as g ");
//        hql.append(" ON u.userId = g.userId ");

        hql.append(" FROM User u ");
        hql.append(" LEFT JOIN FETCH u.mainGroup g ");
        hql.append(" LEFT JOIN FETCH u.userDetailJapaneses d ");

        System.out.println(hql.toString());

        Query query = getSession().createQuery(hql.toString());



        return (List<User>) query.list();
    }
}
