package modules.webTestBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LogUtil;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Argus
 * @className BaseFunction
 * @description: WebTest 测试方法基类
 * @date 2020/11/22 17:06
 * @Version V1.0
 */
public class BaseFunction {

    private static Random random = new Random();

    /**
     * Judge the element to be visible
     * @param driverWait
     * @param element
     * @return Boolean
     */
    public static Boolean waitForElementVisibility(WebDriverWait driverWait, WebElement element) {
        try {
            driverWait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String getMd5(String plainText) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(plainText.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

    public static String  getRandomFromStringList(ArrayList<String> inputList) {
        int n = random.nextInt( inputList.size());
        return  inputList.get(n) ;
    }

    public static WebElement  getRandomFromWebEleList(List<WebElement> inputList) {
        int n = random.nextInt( inputList.size());
        return  inputList.get(n) ;
    }

    public static Double getDoubleFromString(String str) {
//        Integer number=Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim());
//        String numberStr = "00" + number.toString();
        String numberStr = "00" + Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
//        Print(numberStr);
        StringBuffer stringBuilder1 = new StringBuffer( numberStr );
        stringBuilder1.insert(numberStr.length() - 2,".");
        return new Double(stringBuilder1.toString());

    }

    public static String getIntStringFromString(String str) {
        String number=Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
//        String numberStr = number.toString();
        return number;
    }

    /**
     * 从字符串中获取数字
     * @param str
     * @return
     */
    public static Integer  getIntFromString(String str) {
        String number=Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim();
        return Integer.valueOf(number);
    }

    public static ArrayList<String> getXpaths(String line){
        // 按指定模式在字符串查找
//        String pattern = "\\w*xpath=\"(.*?)\",\\w*";
        String pattern = "\\w*xpath=(.*?), using=\\w*";
//        String pattern = "\\w*xpath=(.*?)(?=, )\\w*";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 现在创建 matcher 对象
        Matcher m = r.matcher(line);
        ArrayList<String> matchXpaths = new ArrayList<>();
        while (m.find()) { //此处find（）每次被调用后，会偏移到下一个匹配
            matchXpaths.add(m.group(1));//获取当前匹配的值
        }
        System.out.println(matchXpaths);
        return matchXpaths;
    }

    public static String getPassMd5(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            return buf.toString();
            //System.out.println("result: " + buf.toString());// 32位的加密
            //System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static ArrayList<String> getErrorElesListNotIncludeUnwanted (ArrayList<String>  errorElesList, ArrayList<String> nnWantedElesList) {
        ArrayList<String> errorElesListNotIncludeUnwanted =  new ArrayList<>();
        for ( String errorEle: errorElesList){
            boolean isUnWantedEles = false;
            for (String each:nnWantedElesList){
                if ( errorEle.contains( each )){ isUnWantedEles = true; break;}
            }
            if ( !isUnWantedEles ) {
                errorElesListNotIncludeUnwanted.add( errorEle );
                LogUtil.APP.error("ErrorEle ======== " + errorEle);
            }
        }
        return errorElesListNotIncludeUnwanted;
    }

    public static <T> void swap(T[] a, int i, int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void shuffle(T[] arr) {
        int length = arr.length;
        for ( int i = length; i > 0; i-- ){
            int randInd = random.nextInt(i);
            swap(arr, randInd, i - 1);
        }
    }
}