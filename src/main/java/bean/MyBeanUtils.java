package bean;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/22 11:50
 */

public class MyBeanUtils {

    //https://blog.csdn.net/qq_32786139/article/details/106358162
    public static boolean checkNullFileObject(Object object) {
        boolean target = false;
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                String name = f.getName();
                if (f.get(object) != null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                    target = true;
                    break;
                }
            } catch (IllegalArgumentException e) {
                target = false;
                return target;
            } catch (IllegalAccessException e) {
                target = false;
                return target;
            }
        }
        return target;
    }

    public static boolean validateFild(Object object) {
        List<String> exclFild = Arrays.asList("serialVersionUID");
        boolean target = false;
        for (Field f : object.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                String name = f.getName();
                // 判断属性名称是否在排除属性值中
                if (!exclFild.contains(name)) {
                    if (f.get(object) != null) { //判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
                        target = true;
                        break;
                    }
                }
            } catch (IllegalArgumentException e) {
                target = false;
                return target;
            } catch (IllegalAccessException e) {
                target = false;
                return target;
            }
        }
        return target;
    }


}