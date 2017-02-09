package com.ls.util;

import java.io.Serializable;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    public abstract CMapper getMapper();

    @Override
    public T getById(ID id) {
        return (T) getMapper().selectByPrimaryKey(id);
    }
}
