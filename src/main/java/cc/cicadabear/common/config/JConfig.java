package cc.cicadabear.common.config;

import cc.cicadabear.common.util.PropertiesLoader;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Jcc全局配置
 *
 * @author cc
 */
public class JConfig {

    /**
     * 保存全局属性值
     */
    private static Map<String, String> map = Maps.newHashMap();

    /**
     * 属性文件加载对象
     */
    private static PropertiesLoader loader;

    /**
     * 获取配置
     */
    public static String getConfig(String key) {
        loader = PropertiesLoader.getSingleton();
        String value = map.get(key);
        if (value == null) {
            value = loader.getProperty(key);
            map.put(key, value != null ? value : StringUtils.EMPTY);
        }
        return value;
    }

    public static Integer getInteger(String key) {
        return Integer.valueOf(getConfig(key));
    }

    public static Boolean getBoolean(String key) {
        return Boolean.valueOf(getConfig(key));
    }

    public static final String CURRENT_USER = "user";
    public static final String SESSION_FORCE_LOGOUT_KEY = "session.force.logout";
    public static final String MESSAGE = "message";
    public static final String PARAM_DIGEST = "digest";
    public static final String PARAM_USERNAME = "username";
    /**
     * 文件上传位置
     */
    public static String FILEUPLOAD = "file.upload";
}
