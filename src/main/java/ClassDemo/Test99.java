package ClassDemo;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Description:
 * @author:ljh
 * @date:2021/12/2 10:42
 */

public class Test99 {

    @Test
    public void test() {
        Set<Person> personSet = new HashSet<>();
        Person person = new Person("123", 123);
        Person person1 = new Person("123", 68);
        Person person2 = new Person("123", 689);
        Person person3 = new Person("85", 689);
        personSet.add(person);
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);


        Map<String, Object> map = objectToMap(person);
        System.out.println(map);

     String q = "2-1";
     Integer i = new Integer(q);
        System.out.println(i);


    }

    public static Map<String, Object> objectToMap(Object obj) {
        String jsonStr = JSONObject.toJSONString(obj);
        return JSONObject.parseObject(jsonStr);
    }


}