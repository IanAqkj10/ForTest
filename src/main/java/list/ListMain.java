package list;

import ClassDemo.Person;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/23 13:54
 */

public class ListMain {

    public static void main(String[] args) {

       Person person0 = new Person("0",123);
       Person person1 = new Person("1",123);
       Person person2 = new Person("2",123);
       Person person3 = new Person("3",123);
       Person person4 = new Person("4",123);
       Person person5 = new Person("5",123);
       Person person6 = new Person("99",123);
       Person person7 = new Person("99",123);

        List<Person> p1 = new ArrayList<>();
        p1.add(person0);
        p1.add(person1);
        p1.add(person2);
        p1.add(person3);
        p1.add(person6);
        String s = JSON.toJSONString(p1);
        System.out.println(s);


    }

    @Test
    public void test() {
        List<IndustryStockRelation> industryStockRelationList = new LinkedList<>();
        IndustryStockRelation i1 = new IndustryStockRelation(1L,"100720401",3);
        IndustryStockRelation i2 = new IndustryStockRelation(2L,"100720402",6);
        IndustryStockRelation i3 = new IndustryStockRelation(2L,"100720401",9);
        IndustryStockRelation i4 = new IndustryStockRelation(3L,"100720403",6);
        IndustryStockRelation i5 = new IndustryStockRelation(3L,"100720403",98);
        IndustryStockRelation i6 = new IndustryStockRelation(3L,"100720403",5152);
        IndustryStockRelation i7 = new IndustryStockRelation(3L,"100720403",6);
        industryStockRelationList.add(i1);
        industryStockRelationList.add(i2);
        industryStockRelationList.add(i3);
        industryStockRelationList.add(i4);
        industryStockRelationList.add(i5);
        industryStockRelationList.add(i6);
        industryStockRelationList.add(i7);
        Map<String,IndustryStockRelation> map =
                industryStockRelationList.parallelStream().collect(
                        Collectors.groupingBy(IndustryStockRelation::getIndustryCode,
                                Collectors.collectingAndThen(
                                        Collectors.reducing((a,b)->a.getNum()> b.getNum()?a:b), Optional::get)

                        )
                );
        System.out.println(map);
    }


}