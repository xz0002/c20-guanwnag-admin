package com.c20.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.c20.admin.entity.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.c20.admin.entity.vo.ImageVo;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xin
 * @description 针对表【image】的数据库操作Service
 * @createDate 2023-03-06 13:13:02
 */
public interface ImageService extends IService<Image> {

    String upload(MultipartFile file);

    void download(String url);

    void saveOrUpdate(ImageVo imageVo);

    IPage<Image> findPageList(Long page, Long size, String fileName, String description);
}
