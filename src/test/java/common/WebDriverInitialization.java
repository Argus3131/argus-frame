package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import utils.LogUtil;
import utils.PropertiesUtil;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


/**
 * @author Argus
 * @className BaiduPage
 * @description: 初始化webDriver
 * @date 2020/11/22 3:01
 * @Version V1.0
 */
public class WebDriverInitialization{
	// 获取系统名称
	private static final String OS=System.getProperty("os.name").toLowerCase();
	// 获取当前项目路径
	private final static String USER_HOME_DIR = System.getProperty("user.dir");


	/**
	 * 初始化WebDriver
	 * @param driverType 浏览器类型
	 * @return 返回初始化结果
	 * @throws WebDriverException 驱动抛出异常
	 * @throws IOException 读取配置文件异常
	 */
	public static WebDriver setDriver(Integer driverType) throws WebDriverException,IOException{
		if (driverType == null) {
			LogUtil.APP.warn("传入参数不符合数值类型规范，初始化失败:{}",driverType);
			throw new RuntimeException();
		}
		// 获取驱动路径
		String drivenpath= USER_HOME_DIR + File.separator + PropertiesUtil.readProperty("application.properties", "drivers.relative-path") + File.separator;
		WebDriver webDriver = null;
		LogUtil.APP.info("准备初始化WebDriver对象...检查到当前操作系统是:{}",OS);
		switch (driverType) {
			case 0:
				webDriver = WebDriverInitialization.setIEDriver(webDriver,drivenpath);
				break;
			case 1:
				webDriver = WebDriverInitialization.setFirefoxDriver(webDriver,drivenpath);
				break;

			case 2:
				webDriver = WebDriverInitialization.setChromeDriver(webDriver,drivenpath);
				break;
			case 3:
				webDriver = WebDriverInitialization.setEdgeDriver(webDriver,drivenpath);
				break;
			default:
				LogUtil.APP.warn("浏览器类型标识:{}，获取到的浏览器类型标识未定义，默认IE浏览器进行执行....",driverType);
				System.setProperty("webdriver.ie.driver",drivenpath+"IEDriverServer.exe");
				webDriver = new InternetExplorerDriver();
		}
		// 解决webdriver在unix环境中，最大化会出现异常的bug，unix最大化在options中单独设置
		if(OS.startsWith("win")){
			assert webDriver != null;
			webDriver.manage().window().maximize();
		}
		// 设置页面加载最大时长30秒
		assert webDriver != null;
		webDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		// 设置元素出现最大时长30秒
		webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return webDriver;
	}


	public static WebDriver setIEDriver(WebDriver webDriver,String drivenpath) {
		if(OS.startsWith("win")){
			System.setProperty("webdriver.ie.driver",drivenpath+"IEDriverServer.exe");
			webDriver = new InternetExplorerDriver();
		}else{
			LogUtil.APP.warn("当前操作系统无法进行IE浏览器的Web UI测试，请选择火狐或是谷歌浏览器！");
		}
		return webDriver;
	}

	public static WebDriver setFirefoxDriver(WebDriver webDriver,String drivenpath) {
		FirefoxOptions options = new FirefoxOptions();
		if(OS.startsWith("win")){
			System.setProperty("webdriver.gecko.driver",drivenpath+"geckodriver.exe");
		}else if(OS.contains("mac")){
			options.addArguments("start-maximized");
			System.setProperty("webdriver.gecko.driver",drivenpath+"geckodriver_mac");
		}else{
			LogUtil.APP.info("检测到当前系统环境是Linux,默认使用headless方式运行Firefox浏览器的Web UI自动化...");
			//无界面参数
			options.setHeadless(true);
			//禁用沙盒
			options.addArguments("no-sandbox");
			options.addArguments("start-maximized");
			System.setProperty("webdriver.gecko.driver",drivenpath+"geckodriver_linux64");
		}
		webDriver = new FirefoxDriver(options);
		return webDriver;
	}


	public static WebDriver setChromeDriver(WebDriver webDriver,String drivenpath) {
		ChromeOptions options = new ChromeOptions();
		if(OS.startsWith("win")){
			System.setProperty("webdriver.chrome.driver",drivenpath+"chromedriver.exe");
		}else if(OS.contains("mac")){
			options.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver",drivenpath+"chromedriver_mac");
		}else{
			LogUtil.APP.info("检测到当前系统环境是Linux,默认使用headless方式运行Chrome浏览器的Web UI自动化...");
			//无界面参数
			options.setHeadless(true);
			//禁用沙盒
			options.addArguments("no-sandbox");
			options.addArguments("start-maximized");
			System.setProperty("webdriver.chrome.driver",drivenpath+"chromedriver_linux64");
		}
		webDriver = new ChromeDriver(options);
		return webDriver;
	}

	public static WebDriver setEdgeDriver(WebDriver webDriver,String drivenpath) {
		if(OS.startsWith("win")){
			System.setProperty("webdriver.edge.driver",drivenpath+"msedgedriver.exe");
			webDriver = new EdgeDriver();
		}else if(OS.contains("mac")){
			System.setProperty("webdriver.edge.driver",drivenpath+"msedgedriver_mac");
			webDriver = new EdgeDriver();
		}else{
			LogUtil.APP.warn("当前操作系统无法进行Edge浏览器的Web UI测试，请选择火狐或是谷歌浏览器！");
		}
		return webDriver;
	}

}
