package utils;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	public static boolean isNotEmpty(String str) {
		return null != str && !"".equals(str);
	}

	public static boolean isEmpty(String str) {
		return null == str || "".equals(str);
	}
	
	/**
	 * 
	 * @param sourceStr 待替换字符串
	 * @param matchStr  匹配字符串
	 * @param replaceStr  目标替换字符串
	 * @return
	 */
	public static String replaceFirst(String sourceStr,String matchStr,String replaceStr){
		int index = sourceStr.indexOf(matchStr);
		int matLength = matchStr.length();
		int sourLength = sourceStr.length();
		String beginStr = sourceStr.substring(0,index);
		String endStr = sourceStr.substring(index+matLength,sourLength);
		sourceStr = beginStr+replaceStr+endStr;
		return sourceStr;
	}


	public static String upperCase(String str) {
		if (StringUtils.isEmpty(str)) {return "";}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}


	public static void main(String[] args) {

	}
}
