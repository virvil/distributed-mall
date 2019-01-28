package distributed.mall.user.web;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import distributed.mall.common.utils.FastDFS.FastDFSClientUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubboConfig
public class DistributedMallUserWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedMallUserWebApplication.class, args);
    }


}

