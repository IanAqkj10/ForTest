package dir;

import java.io.File;

/**
 * @Description:
 * @author:ljh
 * @date:2022/10/26 15:31
 */

public class DirTest {

    public static void main(String[] args) {
        File f = new File("C:\\Users\\刘键豪\\Desktop\\1");
        testFile(f);
    }


    public static void testFile(File dir) {

        File[] files = dir
                .listFiles((d, name) -> new File(d, name).isDirectory() || name.toLowerCase().endsWith(".txt"));
        /*
         * 1.ListFiles会先把传递的目录进行遍历后的结果封装为File对象
         * 2.之后若返回True，则会把这些对象一一传递给过滤器accept方法的参数pathname
         */
        for (File f : files) {
            if (f.isDirectory()) {// 判断是否为文件夹
                testFile(f);
            } else {
                System.out.println(f.getName());
            }
        }


    }

}