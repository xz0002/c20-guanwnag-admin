package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.Permissions;
import com.c20.admin.service.PermissionsService;
import com.c20.admin.mapper.PermissionsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xin
 * @description 针对表【permissions】的数据库操作Service实现
 * @createDate 2023-03-07 10:47:18
 */
@Service
public class PermissionsServiceImpl extends ServiceImpl<PermissionsMapper, Permissions> implements PermissionsService {

    @Resource
    static PermissionsMapper permissionsMapper;

    @Override
    public List<Permissions> findPermissionByRoleId(Long rid) {
        List<Long> ids = permissionsMapper.findPermissionByRoleId(rid);
        return this.listByIds(ids);
    }
}




