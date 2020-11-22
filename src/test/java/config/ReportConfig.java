package config;

import org.apache.commons.lang3.StringUtils;
import org.testng.Reporter;

import java.util.Calendar;

public class ReportConfig {
	private static String reportName = "自动化测试报告";

	private static final String SEPARATOR_TIME_AND_MSG = "......";

	public static void log(String msg) {
		long timeMillis = Calendar.getInstance().getTimeInMillis();
		Reporter.log(timeMillis + SEPARATOR_TIME_AND_MSG + msg, true);
	}

	public static String getReportName() {
		return reportName;
	}

	public static String getSpiltTimeAndMsg() {
		return SEPARATOR_TIME_AND_MSG;
	}

	public static void setReportName(String reportName) {
		if(StringUtils.isNotBlank(reportName)){
			ReportConfig.reportName = reportName;
		}
	}
}

