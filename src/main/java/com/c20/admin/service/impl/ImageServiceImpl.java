package com.c20.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.c20.admin.entity.Image;
import com.c20.admin.service.ImageService;
import com.c20.admin.mapper.ImageMapper;
import org.springframework.stereotype.Service;

/**
* @author xin
* @description 针对表【image】的数据库操作Service实现
* @createDate 2023-03-06 13:13:02
*/
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image>
    implements ImageService{

}




