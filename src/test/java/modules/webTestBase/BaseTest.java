package modules.webTestBase;

import common.WebDriverInitialization;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Random;

/**
 * @author Argus
 * @className BaseTest
 * @description: WebTest 测试准备基类
 * @date 2020/11/22 4:36
 * @Version V1.0
 */
public class BaseTest<T extends BasePage>{

    public WebDriver driver;
    public T page;
    public Random random;

    /**
     * setUp测试类前置准备方法
     * @param clazz
     * @param driverType
     * @param url
     */
    public void setUp(Class<T> clazz,Integer driverType,String url) {

        try {
            driver = WebDriverInitialization.setDriver(driverType);
            driver.get(url);
            page = (T) newTclass(clazz);
            page.setUrl(url);
            page.setDriver(driver);
//            System.out.println(driver);
        } catch (IOException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * clazz 调用的是无参构造方法 因此调用方必须开放空参构造方法
     * @param clazz
     * @param <T>
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static <T> T newTclass(Class<T> clazz) throws InstantiationException, IllegalAccessException{
        T t=clazz.newInstance();
        return t;
    }

    public void tearDown() {
        try {
            page.sleep(1);
            quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    public void quit() {
        driver.quit();
    }

    public void close() {
        driver.close();
    }


}