package distributed.mall.common.utils.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * <b><code>JsonUtil</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/1/14 9:56.
 *
 * @author zyg
 * @since distributed-mall ${PROJECT_VERSION}
 */
public class JsonUtil {

    public static String getJsonString(Object josnObject) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String valueSting = objectMapper.writeValueAsString(josnObject);
        return  valueSting;
    }

    public static Object getJsonObject(String valueString,Class valueType) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Object jsonObject = objectMapper.readValue(valueString, valueType);
        return jsonObject;
    }
}
