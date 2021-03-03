package io.seata.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 库存服务
 * @author wangzhongxiang
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@MapperScan("io.seata.sample.dao")
public class StorageServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StorageServerApplication.class, args);
	}

}
