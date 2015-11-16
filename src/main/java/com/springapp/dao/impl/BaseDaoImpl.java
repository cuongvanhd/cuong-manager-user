package com.springapp.dao.impl;

import com.springapp.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Cuong on 2015/11/16.
 */
public abstract class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    private final Class entityClass;

    public BaseDaoImpl(final Class entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired(required = true)
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public PK save(T entity) {
        return (PK) getSession().save(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void update(T entity) {
        getSession().update(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public T get(PK id) {
        return (T) getSession().get(entityClass, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public List find(String hql) {
        return getSession().createQuery(hql).list();
    }
}
