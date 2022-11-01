package dir;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @author:ljh
 * @date:2022/10/26 15:31
 */

public class DirTest {

    public static void main(String[] args) {
        Date endDate = new Date();
        List<String> dateList = new ArrayList<>();
        for (int i = -1; i > -7; i--) {
            Date selectDate = DateUtils.subDate(endDate, i);
            String strDate = DateUtils.date2Str(selectDate, DateUtils.yyyyMMdd);
            dateList.add(strDate);
        }
        System.out.println(dateList);
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