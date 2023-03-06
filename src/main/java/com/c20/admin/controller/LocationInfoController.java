package com.c20.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.c20.admin.entity.LocationInfo;
import com.c20.admin.entity.vo.LocationInfoVo;
import com.c20.admin.result.Result;
import com.c20.admin.service.LocationInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationInfoController {

    Logger logger = LoggerFactory.getLogger(LocationInfoController.class);

    @Autowired
    private LocationInfoService locationInfoService;

    // 根据经纬度获取位置信息
    @PostMapping("/findLocationInfo")
    public Result findLocationInfo(@RequestBody LocationInfoVo locationInfoVo) {
        QueryWrapper<LocationInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("latitude", locationInfoVo.getLatitude()).eq("longitude", locationInfoVo.getLongitude());
        LocationInfo locationInfo = locationInfoService.getOne(queryWrapper);
        if (locationInfo != null) {
            return Result.ok(locationInfo);
        } else {
            return Result.fail();
        }
    }

    // 根据地区和名字模糊查询分页查询
    @PostMapping("/findPageList/{page}/{size}")
    public Result findPageList(@PathVariable Long page,
                               @PathVariable Long size,
                               @RequestBody LocationInfoVo locationInfoVo) {
        if (page <= 0) page = 1L;
        if (size <= 0) size = 10L;
        // 名称
        String name = locationInfoVo.getName();
        logger.info("name: " + name);
        // 详细信息
        String address = locationInfoVo.getAddress();
        logger.info("address: " + address);

        IPage<LocationInfo> locationInfoIPage = locationInfoService.findPageList(page, size, name, address);
        return Result.ok(locationInfoIPage);
    }

    // 根据id查询位置信息
    @GetMapping("/findById")
    public Result findById(@RequestParam Long id) {
        QueryWrapper<LocationInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("id", id);
        LocationInfo locationInfo = locationInfoService.getOne(wrapper);
        return Result.ok(locationInfo);
    }

    // 保存位置信息
    @PostMapping("/save")
    public Result save(@RequestBody LocationInfo locationInfo) {
        boolean save = locationInfoService.save(locationInfo);
        if (save) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 更新位置信息
    @PutMapping("/update")
    public Result update(@RequestBody LocationInfo locationInfo) {
        boolean update = locationInfoService.updateById(locationInfo);
        if (update) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    // 删除位置信息
    @DeleteMapping("/remove")
    public Result remove(@RequestParam Long id) {
        boolean remove = locationInfoService.removeById(id);
        if (remove) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}
