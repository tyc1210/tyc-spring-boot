package com.tyc.boot.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 类描述
 *
 * @author tyc
 * @version 1.0
 * @date 2024-05-10 14:20:48
 */
@SuppressWarnings("SpringComponentScan")
@SpringBootApplication(scanBasePackages = {
        "${tyc.info.base-package}.server",
        "${tyc.info.base-package}.module"
})
public class TycServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TycServerApplication.class,args);
    }
}
