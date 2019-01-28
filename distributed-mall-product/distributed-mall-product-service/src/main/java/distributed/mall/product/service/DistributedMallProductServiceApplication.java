package distributed.mall.product.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfig
@MapperScan("distributed.mall.pojo.mapper")
public class DistributedMallProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedMallProductServiceApplication.class, args);
    }

}

