package utils;

import java.math.BigDecimal;

/**
 * @author Argus
 * @className DoubleOperationUtil
 * @description: TODO
 * @date 2020/11/22 17:09
 * @Version V1.0
 */
public class DoubleOperationUtil {

    /**
     * 加法运算
     * @param m1
     * @param m2
     * @return
     */
    public static double addDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.add(p2).doubleValue();
    }

    /**
     * 减法运算
     * @param m1
     * @param m2
     * @return
     */
    public static double subDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.subtract(p2).doubleValue();
    }

    /**
     * 乘法运算
     * @param m1
     * @param m2
     * @return
     */
    public static double mulDouble(double m1, double m2) {
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        BigDecimal p3 = new BigDecimal(p1.multiply(p2).doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
        return p3.doubleValue();
    }


    /**
     *  除法运算
     *   @param   m1
     *   @param   m2
     *   @param   scale
     *   @return
     */
    public static double divDouble(double m1, double m2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("Parameter error");
        }
        BigDecimal p1 = new BigDecimal(Double.toString(m1));
        BigDecimal p2 = new BigDecimal(Double.toString(m2));
        return p1.divide(p2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}