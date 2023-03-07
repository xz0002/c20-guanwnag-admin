package com.c20.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.c20.admin.entity.Permissions;
import com.c20.admin.result.Result;
import com.c20.admin.service.PermissionsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-07 10:54
 */
@RestController
@RequestMapping("/permissions")
public class PermissionsController {

    @Resource
    private PermissionsService permissionsService;

    // 分页查询权限列表
    @PostMapping("/findPageList/{limit}/{size}")
    public Result findPageList(@PathVariable("limit") Integer limit,
                               @PathVariable("size") Integer size) {
        Page<Permissions> permissionsPage = new Page<>(limit, size);
        Page<Permissions> page = permissionsService.page(permissionsPage, null);
        return Result.ok(page);
    }

    // 添加权限
    @PostMapping("/save")
    public Result save(@RequestBody Permissions permissions) {
        permissionsService.save(permissions);
        return Result.ok();
    }

    // 修改权限
    @PostMapping("/update")
    public Result update(@RequestBody Permissions permissions) {
        permissionsService.updateById(permissions);
        return Result.ok();
    }

    // 删除权限
    @PostMapping("/remove")
    public Result remove(@RequestParam Long id) {
        permissionsService.removeById(id);
        return Result.ok();
    }
}
