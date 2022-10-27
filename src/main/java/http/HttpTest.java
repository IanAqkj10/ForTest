package http;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author:ljh
 * @date:2022/10/14 9:49
 */

public class HttpTest {


    public static void main(String[] args) throws Exception {

        String url = "https://open.ys7.com/api/lapp/token/get";
        Map<String, String> data = new HashMap<>();
        data.put("appKey", "81881394e5784b5ea243acbd36ff2607");
        data.put("appSecret", "09102d7a6f840b3c7da875b367092231");
        HttpClientResult result = HttpClientUtils.doPost(url, data);
        System.out.println(result.getContent());


    }


    @Test
    public void qaq(){
       String q= "dwqedqwrqwrq";
        int i = q.indexOf("-");
        if (i != -1) {
            System.out.println("qaq");
        }
    }
}