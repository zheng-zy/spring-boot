package com.ls.util;

import com.github.pagehelper.PageHelper;
import com.ls.model.BaseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@Service
@Transactional
public abstract class MyServiceImpl<T extends BaseEntity> implements MyService<T> {

    public abstract MyMapper<T> getMapper();

    @Override
    public List<T> selectAll(T t) {
        if (t.getPage() != null && t.getRows() != null) {
            PageHelper.startPage(t.getPage(), t.getRows());
        }
        return getMapper().selectAll();
    }

    @Override
    public T selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int save(T t) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return 0;
    }

    @Override
    public List<T> findTByT(T t) {
        return null;
    }

    @Override
    public T findTByTOne(T t) {
        return null;
    }
}
