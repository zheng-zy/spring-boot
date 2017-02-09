package com.ls.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
public abstract class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    public abstract BaseMapper getMapper();

    @Override
    public List<T> list(Integer page, Integer rows) {
        page = page == null ? 0 : page;
        rows = rows == null ? 10 : rows;
        PageHelper.startPage(page, rows);
        List<T> tList = getMapper().selectAll();
        logger.debug("Total: " + ((Page) tList).getTotal());
        return tList;
    }

    @Override
    public int save(T t) {
        return getMapper().insertSelective(t);
    }

    @Override
    public int update(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(ID id) {
        return getMapper().deleteByPrimaryKey(id);
    }

    @Override
    public T getById(ID id) {
        return (T) getMapper().selectByPrimaryKey(id);
    }


}
