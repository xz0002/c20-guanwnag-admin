package com.c20.admin.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author 辛老板
 * @version 1.0.0
 * @date 2023-03-06 20:34
 */
public class OssUtil {

    // Endpoint以杭州为例，其它Region请按实际情况填写。
    static String endpoint = ConstantOssPropertiesUtils.EDNPOINT;
    static String accessKeyId = ConstantOssPropertiesUtils.ACCESS_KEY_ID;
    static String accessKeySecret = ConstantOssPropertiesUtils.SECRECT;
    static String bucketName = ConstantOssPropertiesUtils.BUCKET;

    public static String upload(MultipartFile file) {
        try {
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            String filename = file.getOriginalFilename();
            filename = UUID.randomUUID().toString().replaceAll("-", "") + filename;
            filename = new DateTime().toString("yyyy/MM/dd") + "/" + filename;

            InputStream inputStream = file.getInputStream();
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, filename, inputStream);
            // 设置该属性可以返回response。如果不设置，则返回的response为空。
            putObjectRequest.setProcess("true");
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);
            if (result.getResponse().getStatusCode() == 200) {
                return "https://" + bucketName + "." + endpoint + "/" + filename;
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void download(String url) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 下载Object到本地文件，并保存到指定的本地路径中。如果指定的本地文件存在会覆盖，不存在则新建。
            // 如果未指定本地路径，则下载后的文件默认保存到示例程序所属项目对应本地路径中。

            String downloadDir = System.getProperty("user.home") + "/Downloads"; // 获取下载文件夹路径
            File downloadDirFile = new File(downloadDir);
            if (downloadDirFile.exists() && downloadDirFile.isDirectory()) {
                // 下载文件夹存在
                ossClient.getObject(new GetObjectRequest(bucketName, url), downloadDirFile);
            } else {
                // 下载文件夹不存在
                downloadDirFile.mkdir();
                ossClient.getObject(new GetObjectRequest(bucketName, url), downloadDirFile);
            }
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
}
