import java.text.DecimalFormat;
import java.util.Random;

/**
 * @Description:
 * @author:ljh
 * @date:2022/4/21 11:19
 */

public class HttpTest {

    Random random = new Random();
    DecimalFormat fourdf = new DecimalFormat("0000");

//    @Test
//    public void qaq(){
//        try {
//            HttpClientResult httpClientResult = HttpClientUtils.doGet("https://www.chinaport.gov.cn/api/policyDocumentList?pageNum=3&pageSize=8");
//            String content = httpClientResult.getContent();
//            Map map = new HashMap();
//            Map map1 = JSONObject.parseObject(content, Map.class);
//            Integer count = Integer.valueOf((String) map1.get("count"));
//            map.put("count",count);
//            List<Map<String, Object>> list = new ArrayList<>();
//            List<Map<String, Object>> message = (List<Map<String, Object>>) map1.get("message");
//            message.forEach(m->{
//                Set<Map.Entry<String, Object>> entrySet = m.entrySet();
//                Map<String, Object> data = new HashMap<>();
//                entrySet.forEach(e ->{
//                    if (e.getKey().equals("id") || e.getKey().equals("sortDate") || e.getKey().equals("title")){
//                        data.put(e.getKey(),e.getValue());
//                    }
//                });
//                list.add(data);
//            });
//            map.put("list",list);
//            JSONObject j = new JSONObject(map);
//            System.out.println(j);
////            System.out.println(map);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

}