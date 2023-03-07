package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.Users;
import com.c20.admin.service.UsersService;
import com.c20.admin.mapper.UsersMapper;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @description 针对表【users】的数据库操作Service实现
 * @createDate 2023-03-07 10:47:18
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}




