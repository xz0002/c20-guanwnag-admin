package com.c20.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.c20.admin.entity.RolePermissions;
import com.c20.admin.entity.Roles;
import com.c20.admin.result.Result;
import com.c20.admin.service.RolePermissionsService;
import com.c20.admin.service.RolesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-07 10:53
 */
// 角色管理
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Resource
    private RolesService rolesService;

    @Resource
    private RolePermissionsService rolePermissionsService;

    // 查询所有角色
    @GetMapping("/findAll")
    public Result findAll() {
        return Result.ok(rolesService.list());
    }

    // 分页查询角色列表
    @PostMapping("/findPageList/{limit}/{size}")
    public Result findPageList(@PathVariable("limit") Integer limit,
                               @PathVariable("size") Integer size) {
        Page<Roles> rolesPage = new Page<>(limit, size);
        Page<Roles> page = rolesService.page(rolesPage, null);
        return Result.ok(page);
    }

    // 添加角色
    @PostMapping("/save")
    public Result save(@RequestBody Roles roles) {
        rolesService.save(roles);
        return Result.ok();
    }

    // 修改角色
    @PutMapping("/update")
    public Result update(@RequestBody Roles roles) {
        rolesService.updateById(roles);
        return Result.ok();
    }

    // 删除角色
    @DeleteMapping("/remove")
    public Result remove(@RequestParam Long id) {
        rolesService.removeById(id);
        return Result.ok();
    }

    // 给角色赋权
    @PostMapping("/setPermissions")
    public Result addUserPermission(@RequestParam Long permissionId,
                                    @RequestParam Long roleId) {
        RolePermissions rolePermissions = new RolePermissions();
        rolePermissions.setPermissionId(permissionId);
        rolePermissions.setRoleId(roleId);
        boolean save = rolePermissionsService.save(rolePermissions);
        if (save) {
            return Result.ok();
        }
        return Result.fail();
    }
}
