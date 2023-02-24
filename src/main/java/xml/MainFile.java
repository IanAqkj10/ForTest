package xml;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/23 9:23
 */

public class MainFile {


    public static void main(String[] args) throws Exception {

        String path = "C:\\Users\\刘键豪\\Desktop\\dt临时\\HistoryData\\Config\\Config.xml";
//        String content = new String(Files.readAllBytes(Paths.get(path)));
        String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        System.out.println(content);
        File file = new File(path);




        System.out.println("=============");
        Elements parse = Jsoup.parse(content).select("666");

        System.out.println(parse.text());
        System.out.println("-===============");
        Predicate<String> t = String::isEmpty;


    }

    @Test
    public void test() throws Exception {

        String templateId = "1,2,3,4,5";
//字符串拆分
        String[] templateIdlist = templateId.split(",");
//转成Long类型数组
        List<Long> idList = Arrays.stream(templateIdlist)
                .map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        System.out.println(idList);

        Long[] longs = idList.stream().toArray(Long[]::new);
        System.out.println(longs);
        System.out.println(Arrays.toString(longs));


    }


    @Test
    public void test111()  {
        BigDecimal secPercent = BigDecimal.valueOf(20).
                divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal("100"));
        System.out.println(secPercent);
    }

}