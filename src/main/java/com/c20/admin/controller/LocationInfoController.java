package com.c20.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.c20.admin.entity.LocationInfo;
import com.c20.admin.entity.vo.LocationInfoVo;
import com.c20.admin.service.LocationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/location")
public class LocationInfoController {

    @Autowired
    private LocationInfoService locationInfoService;

    // 获取位置信息
    @PostMapping("/getLocationInfo")
    public ResponseEntity<LocationInfo> getLocationInfo(@RequestBody LocationInfoVo locationInfoVo) {
        QueryWrapper<LocationInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("latitude", locationInfoVo.getLatitude()).eq("longitude", locationInfoVo.getLongitude());
        LocationInfo locationInfo = locationInfoService.getOne(queryWrapper);
        if (locationInfo != null) {
            return new ResponseEntity<>(locationInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 保存位置信息
    @PostMapping("/saveLocationInfo")
    public ResponseEntity saveLocationInfo(@RequestBody LocationInfo locationInfo) {
        boolean save = locationInfoService.save(locationInfo);
        if (save) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 更新位置信息
    @PostMapping("/updateLocationInfo")
    public ResponseEntity updateLocationInfo(@RequestBody LocationInfo locationInfo) {
        boolean update = locationInfoService.updateById(locationInfo);
        if (update) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 删除位置信息
    @PostMapping("/deleteLocationInfo")
    public ResponseEntity deleteLocationInfo(@RequestBody LocationInfo locationInfo) {
        boolean remove = locationInfoService.removeById(locationInfo.getId());
        if (remove) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 上传/更新 位置图片
    @PostMapping("/uploadLocationImg/{id}")
    public ResponseEntity uploadLocationImg(MultipartFile file, @PathVariable Integer id) {
        // TODO
        // 文件上传功能
        // 更新数据库对应url字段
        return null;
    }
}
