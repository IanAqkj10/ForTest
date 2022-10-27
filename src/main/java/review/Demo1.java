package review;

import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * @author:ljh
 * @date:2022/8/2 20:33
 */

public class Demo1 {


    @Test
    public void test()  {
        try {
            OutputStream fis = new FileOutputStream("C:\\Users\\刘键豪\\Desktop\\2.txt");
            BufferedOutputStream o = new BufferedOutputStream(fis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}