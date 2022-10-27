package netty;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/17 9:19
 */

public class NettyDemo01 {

    public static void main(String[] args) throws Exception {
        List<Map<String, Object>> leftEn = new ArrayList<>();
//        HashMap<String, Object> lmap = new HashMap<>();
//        lmap.put("1", "123");
//        lmap.put("2", "123");
//
//        HashMap<String, Object> lmap1 = new HashMap<>();
//        lmap1.put("12", "123");
//        lmap1.put("22", "123");

        HashMap<String, Object> lmap3 = new HashMap<>();
        lmap3.put("123123", "123");
        lmap3.put("1231", "123");


//        leftEn.add(lmap);
//        leftEn.add(lmap1);
        leftEn.add(lmap3);

        List<Map<String, Object>> rightEn = new ArrayList<>();
        HashMap<String, Object> emap = new HashMap<>();
        emap.put("1", "123");
        emap.put("2", "123");

        HashMap<String, Object> emap2 = new HashMap<>();
        emap2.put("12", "123");
        emap2.put("22", "123");

        HashMap<String, Object> emap3 = new HashMap<>();
        emap3.put("99", "123");
        emap3.put("123", "123");

        rightEn.add(emap);
        rightEn.add(emap2);
        rightEn.add(emap3);

        System.out.println(leftEn);
        System.out.println(rightEn);

        System.out.println("-=====");
        rightEn.removeAll(leftEn);
        System.out.println(rightEn);
    }


    public boolean checkObjFieldIsNull(Object obj) throws IllegalAccessException {

        boolean flag = false;
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            if (f.get(obj) == null) {
                flag = true;
                return flag;
            }
        }
        return flag;
    }


}