package modules.webTestBase;

import config.ReportLogger;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import testcase.dbTest.DbDemoTest;

/**
 * https://www.seleniumeasy.com/selenium-tutorials/page-factory-pattern-in-selenium-webdriver
 *
 * @Cachelookup
 * https://www.toolsqa.com/selenium-webdriver/cachelookup-in-pageobjectmodel/
 *
 * 页面工厂设计模式
 */
@NoArgsConstructor
@Getter
@Setter
public abstract class BasePage {

    public WebDriver driver;

    public WebDriverWait shortDriverWait;
    // 当前页面的url 当此页面被实例化时 会被赋值
    public String url;
    // 等待超时时间为3秒
    private static final int TIMEOUT = 3;

    public Actions action;

    public JavascriptExecutor jsExecutor;

    private static final ReportLogger reportLogger = ReportLogger.getReportLogger(DbDemoTest.class);

    /**
     * Thread sleep n second
     * @param second n
     * @throws InterruptedException ex
     */
    public void sleep(int second) {
        try {
            Thread.sleep(1000 * second);
        }catch (InterruptedException e) {
            reportLogger.info("线程睡眠失败",e.getMessage());
        }
    }

    /**
     * 页面对象元素懒加载实例化 且元素等待1s
     * @param driver drivers : chrome|ie|fireFox...
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // 一旦调用initElements()方法，所有元素都将被初始化
        // AjaxElementLocatorFactory的工厂会懒加载页面对象的元素 仅当在任何操作中使用WebElement时才标识WebElement
        // 可以借助AjaxElementLocatorFactory将WebElement的超时分配给Object页面类
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT) , this);
        // 元素等待
        shortDriverWait = new WebDriverWait(driver, 1);
    }


}
