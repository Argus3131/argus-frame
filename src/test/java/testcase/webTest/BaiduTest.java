package testcase.webTest;

import application.webTest.page.baidu.BaiduPage;
import common.DriverType;
import config.ReportLogger;
import modules.webTestBase.BaseTest;
import org.testng.annotations.*;
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

    private static final ReportLogger reportLogger = ReportLogger.getReportLogger(BaiduTest.class);

//    @BeforeSuite
//    public void setUp() {
//        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
//        page = new BaiduPage(super.driver);
//    }

    @Test(priority=0)
    public void test1() {
        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
        page = new BaiduPage(super.driver);
        reportLogger.info("百度搜索-测试");
        page.search("测试");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        throw new RuntimeException();
//        super.quit();

    }

//    @BeforeTest
//    public void beforeTest() {
//        page = new BaiduPage(super.driver);
//    }

//    @AfterTest
//    public void afterTest() {
//        super.close();
//    }

    @Test(priority=1)
    public void test2() {
        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
        page = new BaiduPage(super.driver);
        reportLogger.info("百度搜索-lol");
        page.search("lol");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        super.quit();
    }

    @Test(priority=2)
    public void test3() {
        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
        page = new BaiduPage(super.driver);
        reportLogger.info("百度搜索-斗罗大陆");
        page.search("斗罗大陆");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        super.quit();
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
    }


}