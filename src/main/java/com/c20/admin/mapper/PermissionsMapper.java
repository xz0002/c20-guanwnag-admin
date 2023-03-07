package com.c20.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.c20.admin.entity.Permissions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xin
 * @description 针对表【permissions】的数据库操作Mapper
 * @createDate 2023-03-07 10:47:18
 * @Entity com.c20.admin.entity.Permissions
 */
@Repository
public interface PermissionsMapper extends BaseMapper<Permissions> {

    List<Long> findPermissionByRoleId(Long id);
}




