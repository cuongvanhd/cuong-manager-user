package com.springapp.dao.impl;

import com.springapp.command.UserInforCommand;
import com.springapp.dao.UserDao;
import com.springapp.entities.User;
import org.hibernate.Query;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
    public List<UserInforCommand> getAllUserInfor(Pageable pageable) {

        List<UserInforCommand> userInforCommands = new ArrayList<UserInforCommand>();
        StringBuilder hql = new StringBuilder();

        hql.append(" select u.userId, g.groupName, u.fullName, u.fullNameKata, u.email, u.tel, u.birthday, j.nameLevel, d.startDate, d.endDate, d.total ");
        hql.append(" from UserDetailJapanese as d ");
//        hql.append(" from User as u ");
        hql.append(" inner join d.japanese j ");
//        hql.append(" inner join u.mainGroup g ");
        hql.append(" right join d.user u  ");
//        hql.append(" left outer join u.userDetailJapanese d  ");
        hql.append(" inner join u.mainGroup g  ");
//        hql.append(" inner join d.japanese j  ");
        hql.append(" order by u.userId asc  ");
//        hql.append(" limit " + pageable.getOffset() + ", " + pageable.getPageSize() + " ");

//        System.out.println(hql.toString());
        Query query = getSession().createQuery(hql.toString());

        // limit offset, pageSize in sql
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<Object> result = query.list();

        Iterator iterator = result.iterator();
        while (iterator.hasNext()) {
            Object[] objects = (Object[]) iterator.next();
            UserInforCommand userInforCommand = new UserInforCommand();
            // set value
            userInforCommand.setUserId((Integer) objects[0]);
            userInforCommand.setGroupName((String) objects[1]);
            userInforCommand.setFullName((String) objects[2]);
            userInforCommand.setFullNameKata((String) objects[3]);
            userInforCommand.setEmail((String) objects[4]);
            userInforCommand.setTel((String) objects[5]);
            userInforCommand.setBirthday((Date) objects[6]);

            if (objects[7] != null) {
                userInforCommand.setNameLevel((String) objects[7]);
            }
            if (objects[8] != null) {
                userInforCommand.setStartDate((Date) objects[8]);
            }
            if (objects[9] != null) {
                userInforCommand.setEndDate((Date) objects[9]);
            }
            if (objects[10] != null) {
                userInforCommand.setTotal((Integer) objects[10]);
            }

            userInforCommands.add(userInforCommand);
        }

        return userInforCommands;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<User> getListUser() {
        StringBuilder hql = new StringBuilder();
        hql.append(" from User user ");
        hql.append(" left join fetch user.mainGroup mainGroup ");
        Query query = getSession().createQuery(hql.toString());
        return query.list();
    }

}
