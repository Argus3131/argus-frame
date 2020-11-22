package common;

/**
 * @author Argus
 * @className DriverType
 * @description: TODO
 * @date 2020/11/22 2:42
 * @Version V1.0
 */
public class DriverType {

    public interface Drivers{
        // ie
        int IE = 0;
        // 火狐
        int FIREFOX = 1;
        // 谷歌
        int CHROME = 2;
        // edge
        int EDGE = 3;
    }

    public static void main(String[] args) {
        System.out.println(Drivers.FIREFOX);
    }
}