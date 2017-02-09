package com.ls.util;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public interface BaseService<T, ID extends Serializable> {

    List<T> list(Integer page, Integer rows);

    int save(T t);

    int update(T t);

    int delete(ID id);

    T getById(ID id);

}
