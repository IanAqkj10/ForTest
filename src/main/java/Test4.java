import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author:IanJ
 * @date:2021/7/3 21:23
 */
public class Test4 {


    public static void main(String[] args) {


        try {
            Person p1 = new Person(null, null);
            System.out.println(p1);
            Map<String, Object> map = objectToMap(p1);
            System.out.println(map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }


    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<String, Object>();
        Class<?> clazz = obj.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            map.put(fieldName, value);
        }
        return map;
    }

}
