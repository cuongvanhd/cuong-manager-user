package com.springapp.dao.impl;

import com.springapp.dao.UserDetailJapaneseDao;
import com.springapp.entities.UserDetailJapanese;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

        List<UserDetailJapanese> userDetailJapaneses = new ArrayList<UserDetailJapanese>();

        StringBuilder hql = new StringBuilder();
        hql.append(" from UserDetailJapanese as d ");
        hql.append(" inner join d.japanese  ");
        Query query = getSession().createQuery(hql.toString());

        userDetailJapaneses = query.list();
//        List<Object> objects = query.list();

//        for (Object object : objects) {
//            userDetailJapaneses.add((UserDetailJapanese) object);
//        }

        return userDetailJapaneses;

    }
}
