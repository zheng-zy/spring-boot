package com.ls.util;

import java.io.Serializable;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public interface BaseService<T, ID extends Serializable> {

    T getById(ID id);

}
