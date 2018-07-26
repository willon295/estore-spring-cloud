package com.briup.estore.common.conf;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 全局配置，初始化支付参数
 */
@Configuration
@Slf4j
@Data
public class Configs {

    @Value("${alipay.server-url}")
    private String serverUrl;

    @Value("${alipay.private-key}")
    private String privateKey;

    @Value("${alipay.format}")
    private String format;

    @Value("${alipay.charset}")
    private String charset;

    @Value("${alipay.alipay-public-key}")
    private String alipayPublicKey;

    @Value("${alipay.sign-type}")
    private String signType;

    @Value("${alipay.app-id}")
    private String appId;

    @Bean
    public AlipayClient alipayClient() {

        log.warn("初始化信息： "+serverUrl
                +"\n___"+privateKey
                +"\n___"+format
                +"\n___"+alipayPublicKey
                +"\n___"+charset
                +"\n___"+signType
                +"\n___"+appId
        );
        return new DefaultAlipayClient(serverUrl, appId, privateKey, format, charset, alipayPublicKey, signType);
    }
}
