package distributed.mall.manager;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * <b><code>DistributedMallManagerApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/25 16:17.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDubboConfig
public class DistributedMallManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributedMallManagerApplication.class,args);
    }
}
