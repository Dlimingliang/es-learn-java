package com.lml.es.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
public class ElasticSearchConfig {
    /**
     * 协议
     */
    private String schema;

    /**
     * 集群地址，如果有多个用“,”隔开
     */
    private String address;

    /**
     * 连接超时时间
     */
    private int connectTimeout;

    /**
     * Socket 连接超时时间
     */
    private int socketTimeout;

    /**
     * 获取连接的超时时间
     */
    private int connectionRequestTimeout;

    /**
     * 最大连接数
     */
    private int maxConnectNum;

    /**
     * 最大路由连接数
     */
    private int maxConnectPerRoute;

    /**
     * 连接ES的用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

}
