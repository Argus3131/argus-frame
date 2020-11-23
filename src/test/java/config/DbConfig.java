package config;


import testcase.dbTest.DbDemoTest;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * 初始化数据库驱动配置
 */
public class DbConfig {
	private static final Properties DB_CONFIG = new Properties();
	private static final String SYS_CONFIG_FILE = "application.properties";
	private static final ReportLogger reportLogger = ReportLogger.getReportLogger(DbDemoTest.class);

	static{
		try {
			InputStream in = new BufferedInputStream(DbConfig.class.getResourceAsStream(SYS_CONFIG_FILE));
			DB_CONFIG.load(new InputStreamReader(in, StandardCharsets.UTF_8));
		} catch (IOException e) {
			reportLogger.info("读取测试驱动application.properties配置文件出现异常，请检查！", e.getMessage());
		}
	}


	private DbConfig(){}

	public static Properties getDbConfiguration(){
		return DbConfig.DB_CONFIG;
	}


}
