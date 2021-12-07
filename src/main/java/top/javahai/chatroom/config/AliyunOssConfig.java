package top.javahai.chatroom.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Hai
 * @program: subtlechat-mini
 * @description:
 * @create 2021/12/5 - 19:25
 **/
@Component
@ConfigurationProperties(prefix="aliyun.oss")
public class AliyunOssConfig {
    private String endpoint;
    private String keyid;
    private String keysecret;
    private String bucketname;


    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getKeyid() {
        return keyid;
    }

    public void setKeyid(String keyid) {
        this.keyid = keyid;
    }

    public String getKeysecret() {
        return keysecret;
    }

    public void setKeysecret(String keysecret) {
        this.keysecret = keysecret;
    }

    public String getBucketname() {
        return bucketname;
    }

    public void setBucketname(String bucketname) {
        this.bucketname = bucketname;
    }
}
