package com.ls.util;

import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public interface MyService<T> {

    List<T> selectAll(T t);

    T selectByPrimaryKey(String id);

    int save(T t);

    int updateByPrimaryKey(T t);

    List<T> findTByT(T t);

    T findTByTOne(T t);
}
