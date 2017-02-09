package com.ls.util;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public interface BaseMapper<T, ID extends Serializable> {

    List<T> selectAll();

    int deleteByPrimaryKey(ID id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(ID id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
}
