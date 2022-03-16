import org.junit.Test;

import java.util.*;

/**
 * @author:IanJ
 * @date:2021/7/2 15:33
 */

public class Test2{

    @Test
   public void tes(){
//
        Person qaq = new Person("qaq", 100);
        Person qbq = new Person("qcq", 50);
        Person qcq = new Person("qcq", 50);
        Person qdq = new Person("qcq", 50);
        Person qqq = new Person("qcqwq", 200);
//
//        ArrayList<Person> list = new ArrayList<>();
//        list.add(qaq);
//        list.add(qbq);
//        System.out.println(knowledgeIsRepeat(list));
        Set<Person> set = new TreeSet<Person>(new Comparator<Person>() {
            public int compare(Person a, Person b) {
                // 字符串则按照asicc码升序排列
                return a.getAge().compareTo(b.getAge());
            }
        });
        set.add(qaq);
        set.add(qbq);
        set.add(qcq);
        set.add(qdq);
        set.add(qqq);
        System.out.println(set);


    }


    private Boolean knowledgeIsRepeat(List<Person> personList) {
        Set<Person> set = new TreeSet<Person>(new Comparator<Person>() {
            public int compare(Person a, Person b) {
                // 字符串则按照asicc码升序排列
                return a.getName().compareTo(b.getName());
            }
        });
        set.addAll(personList);
        if (set.size() < personList.size()) {
            return true;
        }
        return false;
    }


    @Test
    public void qqq(){
        Map map  =new HashMap();

        map.put("1aq",123);
        System.out.println(map);

        map.clear();
        System.out.println(map);


    }

}
