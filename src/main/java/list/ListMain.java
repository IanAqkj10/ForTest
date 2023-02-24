package list;

import ClassDemo.Person;
import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/23 13:54
 */

public class ListMain {

    public static void main(String[] args) {
        String a = "1";

       Person person0 = new Person("12",123);
       Person person1 = new Person("34",123);
       Person person2 = new Person("56",123);
       Person person3 = new Person("78",123);
       Person person4 = new Person("4",123);
       Person person5 = new Person("5",123);
       Person person6 = new Person("99",123);
       Person person7 = new Person("99",123);

        List<Person> p1 = new ArrayList<>();
        p1.add(person0);
        p1.add(person1);
        p1.add(person2);
        p1.add(person3);
        List<Person> collect = p1.stream().filter(p -> p.getName().contains(a)).collect(Collectors.toList());

        System.out.println(StringUtils.isEmpty(collect));
        System.out.println(collect.get(0));


    }

    @Test
    public void test() {
        String factorMin = "1.0";
        LevelItemVo levelItemVo1 = new LevelItemVo(1, 30.0);
        LevelItemVo levelItemVo2 = new LevelItemVo(2, 40.0);
        LevelItemVo levelItemVo3 = new LevelItemVo(3, 94.9);
        LevelItemVo levelItemVo4 = new LevelItemVo(4, 100.9);
        LevelItemVo levelItemVo5 = new LevelItemVo(5, 701.6);

        List<LevelItemVo> levelList = new ArrayList<>();

        levelList.add(levelItemVo1);
        levelList.add(levelItemVo2);
        levelList.add(levelItemVo3);
        levelList.add(levelItemVo4);
        levelList.add(levelItemVo5);
        levelList = levelList.stream().sorted(Comparator.comparing(LevelItemVo::getLevel)).collect(Collectors.toList());
        for (int a = 0; a < levelList.size(); a++) {
            LevelItemVo levelItemVo = levelList.get(a);
            if (a == 0) {
                levelItemVo.setMin(Double.valueOf(factorMin));
            } else {
                LevelItemVo v1 = levelList.get(a - 1);
                levelItemVo.setMin(Double.valueOf(v1.getMax()) + 1.0);
            }
        }
        System.out.println(levelList);
    }


    @Test
    public void testtt() {
        String a  ="0值预警-12312321-123124312";
        List<String> types = Arrays.asList("超标预警", "恒定值不变预警", "0值预警", "传输率预警");
        System.out.println(types.contains(a));
        System.out.println(a.split("-")[1]);
    }

}