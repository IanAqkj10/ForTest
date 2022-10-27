package fileRead;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @Description:
 * @author:ljh
 * @date:2022/9/23 9:23
 */

public class MainFile {


    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\刘键豪\\Desktop\\dt临时\\HistoryData\\Config\\Config.xml";
//        String content = new String(Files.readAllBytes(Paths.get(path)));
        String content = FileUtils.readFileToString(new File(path), StandardCharsets.UTF_8);
        System.out.println(content);

        System.out.println("=============");
        Elements parse = Jsoup.parse(content).select("TCP1IP");
        System.out.println(parse.text());

    }

}