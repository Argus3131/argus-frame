package testcase.webTest;

import application.webTest.page.baidu.BaiduPage;
import common.DriverType;
import config.ReportLogger;
import modules.webTestBase.BaseTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
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

    private static final ReportLogger reportLogger = ReportLogger.getReportLogger(BaiduTest.class);

    @BeforeSuite
    public void setUp() {
        super.setUp(BaiduPage.class, DriverType.Drivers.CHROME, PropertiesUtil.getProperty("url"));
        page = new BaiduPage(super.driver);
    }

    @Test(priority=0)
    public void test1() {
        reportLogger.info("百度搜索-测试");
        page.search("测试");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
        throw new RuntimeException();

    }

    @AfterTest
    public void afterTest() {
        super.close();
    }

    @Test(priority=0)
    public void test2() {
        reportLogger.info("百度搜索-lol");
        page.search("lol");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);

    }

    @Test
    public void test3() {
        reportLogger.info("百度搜索-斗罗大陆");
        page.search("斗罗大陆");
        reportLogger.info("线程睡眠 %s s","1");
        page.sleep(1);
        String className = this.getClass().getName();
        WebDriverUtil.screenShot(page.getDriver(),"百度搜索",className);
    }

    @AfterSuite
    public void tearDown() {
        super.tearDown();
    }


}