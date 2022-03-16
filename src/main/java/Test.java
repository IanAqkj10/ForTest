import java.util.ArrayList;
import java.util.List;

/**
 * @author:IanJ
 * @date:2021/6/27 14:13
 */
public class Test {

    @org.junit.Test
   public void test() throws Exception {
        String content = "java内存模型(Java Memory Model，JMM)是java虚拟机规范定义的，用来屏蔽掉java程序在各种" +
                "不同的硬件和操作系统对内存的访问的差异，这样就可以实现java程序在各种不同的平台上都能达到内存访问的一致性。";
        List<String> keywords = keywords(content);
        System.out.println(keywords);
   }


    public List<String> keywords(String content) throws Exception {
        //去除空格和特殊字符
        String regEx = "[\n\r\t`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？^p]";
        String aa = "";
        content = content.replaceAll(regEx, aa).replaceAll("　", "").replaceAll(" ", "");
        List<String> keywords = new ArrayList<>();
        //提取10个关键词
        TfIdfAnalyzer tfIdfAnalyzer = new TfIdfAnalyzer();
        int top = 10;
        List<Keyword> list = tfIdfAnalyzer.analyze(content, top);
        for (Keyword word : list) {
            keywords.add(word.getName());
        }
        return keywords;
        //123123123
    }




}
