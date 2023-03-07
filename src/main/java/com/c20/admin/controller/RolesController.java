package com.c20.admin.controller;

import com.c20.admin.service.RolesService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-07 10:53
 */
@RestController
@RequestMapping("/roles")
public class RolesController {

    @Resource
    private RolesService rolesService;

}
