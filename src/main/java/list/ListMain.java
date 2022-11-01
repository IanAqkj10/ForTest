package list;

import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/23 13:54
 */

public class ListMain {

    public static void main(String[] args) {
        List<CountVO> countVOList = new LinkedList<>();
        countVOList.add(new CountVO("苹果",100L,"红富士"));
        countVOList.add(new CountVO("苹果",130L,"金元帅"));
        countVOList.add(new CountVO("香蕉",120L,"芭蕉"));
        countVOList.add(new CountVO("香蕉",130L,"米蕉"));
        countVOList.add(new CountVO("西瓜",140L,"麒麟瓜"));
        countVOList.add(new CountVO("西瓜",120L,"黑金刚"));

        countVOList = countVOList.stream()
                // 根据name分组求和, 返回的是Map
                // CountVO::getName 需要分组的字段
                // Collectors.summingLong(CountVO::getCount)  统计总数
                .collect(Collectors.groupingBy(CountVO::getName, Collectors.summingLong(CountVO::getCount)))
                //转为List集合
                .entrySet().stream()
                .map(e -> new CountVO( e.getKey(),e.getValue(),null))
                .collect(Collectors.toList());

        System.out.println(countVOList);
    }

    @Test
    public void test() {

    }



    @Data
    static class CountVO {

        private String name;
        private Long count;

        private String type;

        public CountVO() {
        }

        public CountVO(String name, Long count, String type) {
            this.name = name;
            this.count = count;
            this.type = type;
        }

    }
}