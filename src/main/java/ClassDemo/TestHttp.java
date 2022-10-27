package ClassDemo;

import org.junit.Test;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author:ljh
 * @date:2022/2/14 14:28
 */

public class TestHttp {



    @Test
    public void  test() throws Exception {

//        http.HttpClientResult httpClientResult = HttpClientUtils.doGet("http://localhost:8081/test.action");
//        String content = httpClientResult.getContent();
//        System.out.println(content);
//
//        ClassDemo.ErrorMsg errorMsg = JSON.parseObject(content, ClassDemo.ErrorMsg.class);
//        System.out.println(errorMsg);
//        Map fieldMap = errorMsg.getFieldMap();
//        System.out.println(fieldMap);

    }

    @Test
    public void tt(){
        Date on  = new Date();
        System.out.println(on);
        ArrayList<Person> list = new ArrayList<>();

        list.add(new Person("aa",10,new Date()));
        list.add(new Person("cc",10,new Date()));
        list.add(new Person("bb",10,new Date()));
        list.add(new Person("dd",10,new Date()));
        List<Map<String, Object>> list1 = listConvert(list);
        System.out.println(list1);

    }
    public <T> List<Map<String,Object>> listConvert(List<T> list){
        List<Map<String,Object>> list_map=new ArrayList<Map<String,Object>>();
        try {
            for (T t : list) {
                Field[] fields=t.getClass().getDeclaredFields();
                Map<String, Object> m = new HashMap<String, Object>();
                for(Field field:fields){
                    String keyName=field.getName();
                    PropertyDescriptor pd = new PropertyDescriptor(keyName,t.getClass());
                    Method getMethod = pd.getReadMethod();// 获得getter方法
                    Object o = getMethod.invoke(t);// 执行get方法返回一个Object
                    m.put(keyName, o);
                }
                list_map.add(m);
            }
            return list_map;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @Test
    public void tttt(){

        Person p1 = new Person("qaq", 123);
        Person p2 = new Person("qaq", 123);
        Person p3 = new Person("124315434134", 123);
        Person p4 = new Person("qaq", 123);
        Person p5 = new Person("qaq", 123);
        Person p6 = new Person("qaq", 48949);



       // System.out.println(p1.equals(p2));
        List<Person> list1 = new ArrayList<>();
        List<Person> list2 = new ArrayList<>();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list1.add(p4);
        list1.add(p5);

//        boolean present = list1.stream().filter(l -> l.getAge() > 100000).findAny().isPresent();
//        System.out.println(present);校验是否符合条件  .stream().filter(条件).findAny.isPresent()
        List<List<Person>> splitList = Stream
                .iterate(0, n -> n + 1).limit(3).parallel()
                .map(a -> list1.stream()
                        .skip(a * 2).limit(2).parallel()
                        .collect(Collectors.toList())).collect(Collectors.toList());
      splitList.forEach(s-> System.out.println(s));

    }

    public boolean bijiao(List<Person> l1, List<Person> l2){
        List<String> list = new ArrayList<>();
        for (Person pp : l2) {
            list.add(pp.getName());
        }
        if (l1.size() == l2.size()){
            for (Person p1 : l1) {
                boolean contains = list.contains(p1.getName());
                if (!contains){
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    public static boolean isEquals(List<Person> list1,List<Person> list2) {
        if (null != list1 && null != list2) {
            if (list1.containsAll(list2) && list2.containsAll(list1)) {
                return true;
            }
            return false;
        }
        return true;
    }


    @Test
    public void qaqaq(){
      double a = 1.02;
      double b = 1.42;
        BigDecimal n1 = new BigDecimal(a);
        BigDecimal n2 = new BigDecimal(b);
        ArrayList<BB> bb = new ArrayList<>();
        bb.add(new BB(n1,"123"));
        bb.add(new BB(n2,"143"));
        BigDecimal reduce = bb.stream().map(BB::getBigDecimal).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(reduce);
    }


    public static List<List<?>> splitList(List<?> list, int len) {
        if (list == null || list.size() == 0 || len < 1) {
            return null;
        }
        List<List<?>> result = new ArrayList<List<?>>();
        int size = list.size();
        int count = (size + len - 1) / len;


        for (int i = 0; i < count; i++) {
            List<?> subList = list.subList(i * len, ((i + 1) * len > size ? size : len * (i + 1)));
            result.add(subList);
        }
        return result;
    }
}

