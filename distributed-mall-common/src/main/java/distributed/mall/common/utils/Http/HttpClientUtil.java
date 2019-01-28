package distributed.mall.common.utils.Http;

import com.fasterxml.jackson.databind.ObjectMapper;
import distributed.mall.common.utils.pojo.ResponseResult;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * <b><code>HttpClientUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/11 22:00.
 *
 * @author virvil
 * @since dubbomall ${PROJECT_VERSION}
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(5000).setConnectTimeout(5000).build();


    public static ResponseResult httpGet(String url){

        CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(requestConfig);
        try {
            CloseableHttpResponse httpResponse = closeableHttpClient.execute(httpGet);
            boolean flag = httpResponse.getStatusLine().getStatusCode()== HttpStatus.SC_OK;
            if (flag){
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpEntity, "utf-8");
                System.out.println(result);
                ObjectMapper objectMapper = new ObjectMapper();
                ResponseResult responseResult = objectMapper.readValue(result, ResponseResult.class);
                return responseResult;
            }
            logger.error("get请求提交错误："+url);
        } catch (IOException e) {
            logger.error("get请求提交错误："+url,e);
        }finally {
            httpGet.releaseConnection();
        }
        return null;
    }

}
