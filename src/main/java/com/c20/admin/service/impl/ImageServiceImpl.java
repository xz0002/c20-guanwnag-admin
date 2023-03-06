package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.Image;
import com.c20.admin.entity.vo.ImageVo;
import com.c20.admin.exception.C20AdminException;
import com.c20.admin.mapper.ImageMapper;
import com.c20.admin.result.ResultCodeEnum;
import com.c20.admin.service.ImageService;
import com.c20.admin.utils.OssUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author xin
 * @description 针对表【image】的数据库操作Service实现
 * @createDate 2023-03-06 13:13:02
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Override
    public String upload(MultipartFile file) {

        return OssUtil.upload(file);
    }


    @Override
    public void download(String url) {
        OssUtil.download(url);
    }

    @Override
    public void saveOrUpdate(ImageVo imageVo) {
        if (StringUtils.isEmpty(imageVo.getFilePath())) {
            throw new C20AdminException(ResultCodeEnum.IMAGE_NULL);
        }
        Image image = new Image();
        BeanUtils.copyProperties(imageVo, image);

        QueryWrapper<Image> wrapper = new QueryWrapper<>();
        wrapper.eq("file_path", image.getFilePath()).eq("id", image.getId());
        Image one = this.getOne(wrapper);
        if (one == null) {
            this.save(image);
        } else {
            this.updateById(image);
        }
    }

    @Override
    public IPage<Image> findPageList(Long page, Long size, String fileName, String description) {
        Page<Image> imagePage = new Page<>(page, size);
        QueryWrapper<Image> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(fileName)) {
            wrapper.like("file_name", fileName);
        }
        if (!StringUtils.isEmpty(description)) {
            wrapper.like("description", description);
        }
        return baseMapper.selectPage(imagePage, wrapper);
    }
}




