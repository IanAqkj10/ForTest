package ClassDemo;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Description: 1231312321312
 * @author:ljh
 * @date:2022/5/3 15:04
 */


public class Main {


    public static void main(String[] args) {

        ReentrantLock r = new ReentrantLock();
        ReentrantReadWriteLock rr = new ReentrantReadWriteLock();

    }


    @Test
    public void te() {
        try {
            Person person = new Person();
            System.out.println(checkObjAllFieldsIsNull(person));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkObjAllFieldsIsNull(Object object) {
        if (null == object) {
            return true;
        }
        try {
            for (Field f : object.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (f.get(object) != null && StringUtils.isNotBlank(f.get(object).toString())) {
                    return false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }


    public boolean isValid(String s) {
        // 括号之间的对应规则
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (mappings.containsKey(chars[i])) {
                char topElement = stack.empty() ? '#' : stack.pop();//(
                if (topElement != mappings.get(chars[i])) {//( != {
                    return false;
                }
            } else {
                stack.push(chars[i]);
            }
        }
        return stack.isEmpty();
    }


    @Test
    public void test() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 20; i++) {
            executor.execute(() -> {
                DanLi danLi = DanLi.getDanLi();
                System.out.println(danLi);
            });
        }
        executor.shutdown();
        executor.shutdownNow();
    }

    public static boolean chechStrs(String[] strs) {
        boolean flag = false;
        if (strs != null) {
            // 遍历strs检查元素值
            for (int i = 0; i < strs.length; i++) {
                if (strs[i] != null && strs[i].length() != 0) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }


    public static String replaceSpace(String[] strs) {

        // 如果检查值不合法及就返回空串
        if (!chechStrs(strs)) {
            return "";
        }
        // 数组长度
        int len = strs.length;
        // 用于保存结果
        StringBuilder res = new StringBuilder();
        // 给字符串数组的元素按照升序排序(包含数字的话，数字会排在前面)
        Arrays.sort(strs);
        int m = strs[0].length();
        int n = strs[len - 1].length();
        int num = Math.min(m, n);
        for (int i = 0; i < num; i++) {
            if (strs[0].charAt(i) == strs[len - 1].charAt(i)) {
                res.append(strs[0].charAt(i));
            } else
                break;

        }
        return res.toString();
    }

    @Test
    public void ttttt() {

//        Person a = new Person("dwqdq", 12399898);
//        Person a1 = new Person("dew", 123);
//        Person a2 = new Person("weq", 123);
//        Person a3 = new Person("dwqdq", 1238481125);
//        Person a4 = new Person("dwqweqedq", 123);
//        List<Person> list = new ArrayList<>();
//        list.add(a);
//        list.add(a1);
//        list.add(a2);
//        list.add(a3);
//        list.add(a4);
//        List<Integer> dwqdq = list.stream().filter(f -> f.getName().equals("dwqdq")).map(Person::getAge).collect(Collectors.toList());
//        List<String> a = new ArrayList<>(Arrays.asList("a20220515823.txt", "a2028564632.txt", "a19980515823.txt"));
        Map<String,String> map = new HashMap<>();
        map.put("qaq","dwqdqw");
        map.put("qaq12","dwq32dqw");
        map.put("qaq32","dwqd213qw");
        map.put("qaq343","dwq2314dqw");
        Map<String,String> map1 = new HashMap<>(map);

        map1.put("fdgfdgo","dwjifjiogfog");

        System.out.println(map1);

        map.put("qqqq","qqqq");
        map.remove("qaq");
        System.out.println(map);
        System.out.println("=================");
        System.out.println(map1);


    }


}