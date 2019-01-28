package distributed.mall.sso;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/*
exclude = DataSourceAutoConfiguration.class
避免以下错误
Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubboConfig
public class DistributedMallSsoWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedMallSsoWebApplication.class, args);
    }

}

