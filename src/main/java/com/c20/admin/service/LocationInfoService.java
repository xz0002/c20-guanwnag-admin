package com.c20.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.c20.admin.entity.LocationInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author xin
 * @description 针对表【location_info】的数据库操作Service
 * @createDate 2023-03-06 10:52:19
 */
public interface LocationInfoService extends IService<LocationInfo> {

    IPage<LocationInfo> findPageList(Long page, Long size, String name, String address);

}
