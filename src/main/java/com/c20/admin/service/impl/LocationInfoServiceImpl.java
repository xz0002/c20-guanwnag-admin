package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.LocationInfo;
import com.c20.admin.service.LocationInfoService;
import com.c20.admin.mapper.LocationInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author xin
 * @description 针对表【location_info】的数据库操作Service实现
 * @createDate 2023-03-06 10:52:19
 */
@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoMapper, LocationInfo> implements LocationInfoService {

}




