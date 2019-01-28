package distributed.mall.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubboConfig;
import distributed.mall.common.utils.FastDFS.FastDFSClientUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * <b><code>DistributedMallSsoServiceApplication</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/15 21:03.
 *
 * @author virvil
 * @since distributed-mall ${PROJECT_VERSION}
 */
@SpringBootApplication
@EnableDubboConfig
@MapperScan("distributed.mall.pojo.mapper")
public class DistributedMallUserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DistributedMallUserServiceApplication.class,args);
    }

}
