package cc.cicadabear.web.context;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

/**
 * Created by Jack on 3/13/17.
 */
public class JacksonObjectMapper extends ObjectMapper {
    public JacksonObjectMapper() {
        super();
        setVisibilityChecker(getSerializationConfig()
                .getDefaultVisibilityChecker()
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE)
                .withFieldVisibility(JsonAutoDetect.Visibility.NONE)
                .withGetterVisibility(JsonAutoDetect.Visibility.PUBLIC_ONLY)
                .withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE));
//        disable(SerializationConfig.Feature.WRITE_EMPTY_JSON_ARRAYS);
    }
}
