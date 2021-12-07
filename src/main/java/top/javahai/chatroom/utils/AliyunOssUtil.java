package top.javahai.chatroom.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.javahai.chatroom.config.AliyunOssConfig;

import java.io.InputStream;
import java.util.UUID;

/**
 * @author Hai
 * @program: subtlechat-mini
 * @description: oss文件存储工具类
 * @create 2021/12/5 - 19:28
 **/
@Component
public class AliyunOssUtil {

    @Autowired
    AliyunOssConfig aliyunOssConfig;

    public String upload(InputStream inputStream, String module, String originalFilename) {

        String endpoint = aliyunOssConfig.getEndpoint();
        String keyId = aliyunOssConfig.getKeyid();
        String keySecret = aliyunOssConfig.getKeysecret();
        String bucketName = aliyunOssConfig.getBucketname();

        //判断oss实例是否存在：如果不存在则创建，如果存在则获取
        OSS ossClient = new OSSClientBuilder().build(endpoint, keyId, keySecret);
        try {
            if (!ossClient.doesBucketExist(bucketName)) {
                //创建bucket
                ossClient.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }

            //构建日期路径：avatar/2019/02/26/文件名
            String folder = new DateTime().toString("yyyy/MM/dd");

            //文件名：uuid.扩展名
            String fileName = UUID.randomUUID().toString();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String key = module + "/" + folder + "/" + fileName + fileExtension;

            //文件上传至阿里云
            ossClient.putObject(aliyunOssConfig.getBucketname(), key, inputStream);
            //返回url地址
            return "https://" + bucketName + "." + endpoint + "/" + key;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 关闭OSSClient。
            ossClient.shutdown();
        }
        return null;
    }
}
