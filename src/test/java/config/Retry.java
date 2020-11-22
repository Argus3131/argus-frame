package config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
 * 失败Case 重跑 上限2次
 * https://blog.csdn.net/star890124/article/details/87974159
 */
public class Retry implements IRetryAnalyzer{
    private int count = 1;         //统计测试用例失败的次数
    private final static int Max_Fail_Count = 2; //测试用例最大失败次数
    @Override
    public boolean retry(ITestResult iTestResult) {
        String msg = "执行用例："+iTestResult.getName()+"第"+count+" 次运行失败";
        System.out.println(iTestResult);
        Reporter.log(msg);
        if(count<Max_Fail_Count){
            count++;
            return true;
        }
        return false;
    }

}