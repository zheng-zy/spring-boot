package com.ls.service;

import com.ls.mapper.RoleMapper;
import com.ls.model.Role;
import com.ls.util.BaseServiceImpl;
import com.ls.util.CMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p></p>
 * Created by zhezhiyong@163.com on 2017/2/9.
 */
@Service("roleService")
@Transactional
public class RoleService extends BaseServiceImpl<Role, Integer> {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public CMapper getMapper() {
        return roleMapper;
    }

}
