package com.springapp.dao;

import java.io.Serializable;

/**
 * Created by Cuong on 2015/11/16.
 */
public interface BaseDao<T, PK extends Serializable> {

    PK save(final T entity);

    void saveOrUpdate(final T entity);

    void update(T entity);

    void delete(T entity);

    T get(PK id);
}
