package date;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author:ljh
 * @date:2022/11/2 9:32
 */

public class DateMain {
    public static void main(String[] args) {

        List<List<String>> aa = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("qaq");
        a.add("qaq123");
        a.add("qa3432q");
        a.add("qa2432q");
        a.add("qa3432q");
        a.add("qa234124q");

        for (String s : a) {
            List<String> str = new ArrayList<>();
            str.add(s);
            aa.add(str);
        }
        String[][] res = new String[aa.size()][];
        for (int i = 0; i < res.length; i++) { // 转换方法
            res[i] = aa.get(i).toArray(new String[0]);
        }

        for (int i = 0; i < res.length; i++)
            System.out.println(Arrays.toString(res[i]));


    }

    @Test
    public void tettt() {
        List list = new ArrayList();
        String[] str1 = {"a", "1"};
        String[] str2 = {"b", "2"};
        list.add(str1);
        list.add(str2);
        Object[] s = (Object[]) list.toArray();
        String[][] aa = new String[s.length][];
        for (int i = 0; i < s.length; i++) {
            aa[i] = (String[]) s[i];
        }


    }


}