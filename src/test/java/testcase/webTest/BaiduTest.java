package testcase.webTest;

import application.webTest.page.baidu.BaiduPage;
import common.DriverType;
import modules.webTestBase.BaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import utils.LogUtil;
import utils.PropertiesUtil;
import utils.WebDriverUtil;

/**
 * @author Argus
 * @className BaiduTest
 * @description: TODO
 * @date 2020/11/22 4:18
 * @Version V1.0
 */
public class BaiduTest extends BaseTest {
    private BaiduPage page;

    @BeforeSuite
    public void setUp() {
        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
        page = new BaiduPage(super.driver);
    }

    @Test
    public void test1() {
        page.search("测试");
        page.sleep(1);
        String className = this.getClass().getName();
        LogUtil.APP.info("webDriver正在截图...当前操作类: {}",className);
        throw new RuntimeException();
//        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
//        LogUtil.APP.info("webDriver截图success!");

    }

    @Test
    public void test2() {
        page.search("测试");
        page.sleep(1);
        String className = this.getClass().getName();
        LogUtil.APP.info("webDriver正在截图...当前操作类: {}",className);
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        LogUtil.APP.info("webDriver截图success!");

    }

    @Test
    public void test3() {
        page.search("测试");
        page.sleep(1);
        String className = this.getClass().getName();
        LogUtil.APP.info("webDriver正在截图...当前操作类: {}",className);
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        LogUtil.APP.info("webDriver截图success!");
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
    }


}