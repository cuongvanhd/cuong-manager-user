package com.springapp.dao.impl;

import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import com.springapp.entities.UserDetailJapanese;
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
    public List<UserDetailJapanese> getAllUserInfor() {

        StringBuilder hql = new StringBuilder();
        hql.append(" from UserDetailJapanese as d ");
        hql.append(" inner join d.japanese j ");
        hql.append(" right join d.user u  ");
        hql.append(" inner join u.mainGroup mainGroup  ");
//        hql.append(" LEFT JOIN FETCH k.userDetailJapanese d ");
//        hql.append(" INNER JOINT FETCH d.Japanese m ");

        System.out.println(hql.toString());

        Query query = getSession().createQuery(hql.toString());

        List<Object> objects = query.list();

        return (List<UserDetailJapanese>) query.list();
    }
}
