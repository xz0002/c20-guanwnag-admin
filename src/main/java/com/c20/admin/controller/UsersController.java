package com.c20.admin.controller;

import com.c20.admin.service.UsersService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-07 10:54
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Resource
    private UsersService usersService;

}
