package config;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import utils.LogUtil;
import utils.PropertiesUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * @author Argus
 * @className TestLogListener
 * @description:
 * TestNG+extentReports+log4j2 完善自动化测试框架——美观的报告和保留日志文件
 * https://blog.csdn.net/rongyu3220/article/details/86694118?depth_1-utm_source=distribute.pc_relevant.none-task&utm_source=distribute.pc_relevant.none-task
 * @date 2020/11/23 0:42
 * @Version V1.0
 */
@Slf4j
public class TestLogListener extends TestListenerAdapter {


    /**
     * 开始
     *
     * @param iTestContext ITestContext
     */
    @Override
    public void onStart(ITestContext iTestContext) {
        super.onStart(iTestContext);
        ReportLogger.getReportLogger().info(String.format("====================%s测试开始====================", iTestContext.getName()));
//        LogUtil.APP.info(String.format("====================%s测试开始====================", iTestContext.getName()));
    }

    /**
     * 测试开始
     *
     * @param iTestResult ITestResult
     */
    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
        ReportLogger.getReportLogger().info(String.format("========%s.%s测试开始========", iTestResult.getInstanceName(), iTestResult.getName()));
//        LogUtil.APP.info(String.format("========%s.%s测试开始========", iTestResult.getInstanceName(), iTestResult.getName()));
    }

    /**
     * 测试成功
     *
     * @param iTestResult ITestResult
     */
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        super.onTestSuccess(iTestResult);
        ReportLogger.getReportLogger().info(String.format("========%s.%s测试通过========", iTestResult.getInstanceName(), iTestResult.getName()));

//        LogUtil.APP.info(String.format("========%s.%s测试通过========", iTestResult.getInstanceName(), iTestResult.getName()));
    }

    /**
     * 测试失败
     *
     * @param iTestResult ITestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        super.onTestFailure(iTestResult);
        ReportLogger.getReportLogger().info(String.format("========%s.%s测试失败,失败原因如下：\n%s========", iTestResult.getInstanceName(), iTestResult.getName(), iTestResult.getThrowable()));

//        LogUtil.APP.error(String.format("========%s.%s测试失败,失败原因如下：\n%s========", iTestResult.getInstanceName(), iTestResult.getName(), iTestResult.getThrowable()));

        /**
         * 出现异常进行截图操作，这里得要自己去实现
         */
    }

    /**
     * 测试跳过
     *
     * @param iTestResult ITestResult
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        super.onTestSkipped(iTestResult);
//        LogUtil.APP.info(String.format("========%s.%s跳过测试========", iTestResult.getInstanceName(), iTestResult.getName()));
        ReportLogger.getReportLogger().info(String.format("========%s.%s跳过测试========", iTestResult.getInstanceName(), iTestResult.getName()));
    }

    /**
     * 结束
     *
     * @param iTestContext ITestContext
     */
    @Override
    public void onFinish(ITestContext iTestContext) {
        super.onFinish(iTestContext);
        ReportLogger.getReportLogger().info(String.format("====================%s测试结束====================", iTestContext.getName()));
//        LogUtil.APP.info(String.format("====================%s测试结束====================", iTestContext.getName()));
    }
}