package com.springapp.dao.impl;

import com.springapp.dao.UserDetailJapaneseDao;
import com.springapp.entities.UserDetailJapanese;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Cuong on 2015/11/19.
 */
@Repository("userDetailJapaneseDao")
public class UserDetailJapaneseDaoImpl extends BaseDaoImpl<UserDetailJapanese, Integer> implements UserDetailJapaneseDao {

    public UserDetailJapaneseDaoImpl() {
        super(UserDetailJapanese.class);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List<UserDetailJapanese> getAllDetailUser() {

        StringBuilder hql = new StringBuilder();
        hql.append(" FROM UserDetailJapanese as d ");
//        hql.append(" RIGHT JOINT d.user as u ");
//        hql.append(" INNER JOINT d.japanese  ");
        Query query = getSession().createQuery(hql.toString());
        return query.list();
    }
}
