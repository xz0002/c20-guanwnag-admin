package com.c20.admin.controller;

import com.c20.admin.entity.vo.ImageVo;
import com.c20.admin.result.Result;
import com.c20.admin.service.ImageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-06 12:59
 */
@RestController
@RequestMapping("/image")
public class ImageController {

    @Resource
    private ImageService imageService;


    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file) {
        String url = imageService.upload(file);
        if (url != null) {
            return Result.ok(url);
        }
        return Result.fail();
    }

    @GetMapping("/download")
    public Result download(@RequestParam("url") String url) {
        imageService.download(url);
        return Result.ok();
    }

    // 根据文件名称和描述模糊分页查询
    @PostMapping("/findPageList/{page}/{size}")
    public Result findPageList(@PathVariable Long page, @PathVariable Long size, @RequestBody ImageVo imageVo) {
        if (page <= 0) page = 1L;
        if (size <= 0) size = 10L;

        String fileName = imageVo.getFileName();
        String description = imageVo.getDescription();
        return Result.ok(imageService.findPageList(page, size, fileName, description));
    }

    // 新增或编辑图片描述
    @PutMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody ImageVo imageVo) {
        imageService.saveOrUpdate(imageVo);
        return Result.ok();
    }

    // 删除图片
    @DeleteMapping("/remove")
    public Result remove(@RequestParam Long id) {
        imageService.removeById(id);
        return Result.ok();
    }
}
