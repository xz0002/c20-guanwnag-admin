package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.LocationInfo;
import com.c20.admin.mapper.LocationInfoMapper;
import com.c20.admin.service.LocationInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author xin
 * @description 针对表【location_info】的数据库操作Service实现
 * @createDate 2023-03-06 10:52:19
 */
@Service
public class LocationInfoServiceImpl extends ServiceImpl<LocationInfoMapper, LocationInfo> implements LocationInfoService {

    @Override
    public IPage<LocationInfo> findPageList(Long page, Long size, String name, String address) {
        Page<LocationInfo> infoPage = new Page<>(page, size);
        QueryWrapper<LocationInfo> queryWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            queryWrapper.like("name", name);
        }
        if (!StringUtils.isEmpty(address)) {
            queryWrapper.like("address", address);
        }
        Page<LocationInfo> locationInfoPage = baseMapper.selectPage(infoPage, queryWrapper);
        return locationInfoPage;
    }
}




