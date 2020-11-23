package config;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Reporter;
import utils.WebDriverUtil;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ReportLogger {
    private static ReportLogger reportLogger = null;
    private Logger log = null; //使用org.apache.log4j.Logger 而不是org.slf4j.Logger;
    static final String FQCN = ReportLogger.class.getName();  // og4j把传递进来的callerFQCN在堆栈中一一比较，相等后，再往上一层即认为是用户的调用类

    public ReportLogger(Class<?> clazz){
        log= Logger.getLogger(clazz); // 这里也要改
    }

    public static ReportLogger getReportLogger(Class<?> clazz) {
        if (reportLogger == null) {
            reportLogger = new ReportLogger(clazz);
        }
        return reportLogger;
    }

    public static ReportLogger getReportLogger() {
        if (reportLogger == null) {
            reportLogger = new ReportLogger(ReportLogger.class);
        }
        return reportLogger;
    }

    public void info(String message){
        //使用slf4j打印到控制台或者文件
        log.log(FQCN, Level.INFO,message,null);
        message = getLogTag()+message;
        //记录到Reporter
        Reporter.log(message);
    }

    /**
     *  指定的格式插入字符串
     * @param _format
     * @param message
     */
    public void info(String _format,String message) {
        // String.format("========%s.%s测试通过========", iTestResult.getInstanceName(), iTestResult.getName())
        ReportLogger.getReportLogger().info(String.format(_format, message));

    }


    public static void main(String[] args) {
//        String.format("========%s.%s测试失败,失败原因如下：\n%s========", "iTestResult.getInstanceName()", "iTestResult.getName(), iTestResult.getThrowable()");
        String test = String.format("webDriver正在截图===当前操作类%s", "测试输出");
        System.out.println(test);
    }


    //根据堆栈信息，拿到调用类的名称、方法名、行号
    public String getLogTag(){
        String logTag = "";
        Long timeStamp = System.currentTimeMillis();
        String dateString = timestampToDate(timeStamp);
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for(int i=0;i<stack.length;i++) {
            StackTraceElement s = stack[i];
            if(s.getClassName().equals(log.getName())){
                logTag= "["+dateString+"]"+"["+classNameDeal(s.getClassName())+":"+s.getMethodName()+":"+s.getLineNumber()+"]";
            }
        }
        return logTag;
    }

    //时间戳转date字符串
    public static String timestampToDate(Long timestamp){
        if(timestamp.toString().length() < 13 ){
            timestamp = Long.valueOf(timestamp.toString().substring(0,10)+"000");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date(timestamp);
        String dateStr = sdf.format(date);
        return dateStr;
    }

    //去掉包名，只保留类名
    static String classNameDeal(String allName){
        String[] className = allName.split("\\.");
        return className[className.length-1];
    }
}