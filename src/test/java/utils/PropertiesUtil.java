package utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PropertiesUtil {

//    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private static Properties props;


    static {
        String fileName = "application.properties";
        props = new Properties();
        try {
            props.load(new InputStreamReader(PropertiesUtil.class.getClassLoader().getResourceAsStream(fileName), StandardCharsets.UTF_8));
        } catch (IOException e) {
            LogUtil.APP.error("文件读取失败",e);
        }
    }

    /**
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            return null;
        }
        return value.trim();
    }

    /**
     * @param key
     * @param defaultValue
     * @return
     */
    public static String getProperty(String key, String defaultValue) {
        String value = props.getProperty(key.trim());
        if (StringUtils.isBlank(value)) {
            value = defaultValue;
        }
        return value.trim();
    }

    /**
     * @param propertiesName
     * @param key
     * @return
     */
    public static String readProperty(String propertiesName, String key) {
        if (StringUtils.isBlank(propertiesName)) {
            return "";
        }
        String value = "";
        InputStream is = null;
        try {

            is = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
            Properties p = new Properties();
            p.load(new InputStreamReader(is, "UTF-8"));
            value = p.getProperty(key);
        } catch (IOException e) {
            LogUtil.APP.error("文件读取失败",e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return value;
    }


    public static void main(String[] args) {
        String property = PropertiesUtil.getProperty("url");
        System.out.println(property);
        String url = System.getProperty("user.dir") + File.separator + PropertiesUtil.readProperty("application.properties", "drivers.relative-path") + File.separator;
        System.out.println(url);
        System.out.println(System.getProperty("user.dir"));
        System.out.println("C:\\\\Program Files (x86)\\\\Mozilla Firefox\\\\firefox.exe");
    }
}