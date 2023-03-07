package com.c20.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.c20.admin.entity.UserRoles;
import com.c20.admin.entity.Users;
import com.c20.admin.entity.vo.UsersVo;
import com.c20.admin.result.Result;
import com.c20.admin.service.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-07 10:54
 */
// 用户管理
@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

    @Resource
    private UserRolesService userRolesService;

    // 分页查询用户列表
    @PostMapping("/findPageList/{limit}/{size}")
    public Result findPageList(@PathVariable("limit") Integer limit,
                               @PathVariable("size") Integer size,
                               @RequestBody UsersVo usersVo) {
        Page<Users> usersPage = new Page<>(limit, size);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.like("username", usersVo.getUsername());
        Page<Users> page = usersService.page(usersPage, wrapper);
        return Result.ok(page);
    }

    // 添加用户
    @PostMapping("/save")
    public Result save(@RequestBody Users users) {
        usersService.save(users);
        return Result.ok();
    }

    // 修改用户
    @PutMapping("/update")
    public Result update(@RequestBody Users users) {
        usersService.updateById(users);
        return Result.ok();
    }

    // 删除用户
    @DeleteMapping("/remove")
    public Result remove(@RequestParam Long id) {
        usersService.removeById(id);
        return Result.ok();
    }

    // 查询某角色下的所有用户
    @GetMapping("/findUsersByRoleId/{roleId}")
    public Result findUsersByRoleId(@PathVariable("roleId") Long roleId) {
        List<Users> list = usersService.findUsersByRoleId(roleId);

//        QueryWrapper<Roles> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", roleId);
//        Roles r = rolesService.getOne(wrapper);
//        r.setUsersList(list);
        return Result.ok(list);
    }

    // 给用户添加角色
    @PostMapping("/setRoles")
    public Result addUserRole(@RequestParam Long userId,
                              @RequestParam Long roleId) {
        UserRoles userRoles = new UserRoles();
        userRoles.setRoleId(roleId);
        userRoles.setUserId(userId);
        boolean save = userRolesService.save(userRoles);
        if (save) {
            return Result.ok();
        }
        return Result.fail();
    }
}