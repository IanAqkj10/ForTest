

/**
 * @Description:
 * @author:ljh
 * @date:2022/4/7 9:37
 */

public class Note {

//    private static final Integer MAX_SEND = 3;
//
//    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
//        int limit = countStep(list.size());
//        //方法一：使用流遍历操作
//        List<List<Integer>> mglist = new ArrayList<>();
//        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
//            mglist.add(list.stream().skip(i * MAX_SEND).limit(MAX_SEND).collect(Collectors.toList()));
//        });
//
//        System.out.println(mglist);
//
//        //方法二：获取分割后的集合
//        List<List<Integer>> splitList = Stream.iterate(0, n -> n + 1).limit(limit).parallel().map(a -> list.stream().skip(a * MAX_SEND).limit(MAX_SEND).parallel().collect(Collectors.toList())).collect(Collectors.toList());
//
//        System.out.println(splitList);
//    }
//
//    /**
//     * 计算切分次数
//     */
//    private static Integer countStep(Integer size) {
//        return (size + MAX_SEND - 1) / MAX_SEND;
//    }


//将ArrayList<Map<String, Object>>类型数据转换成json字符串
//    ArrayList<Map<String, Object>> list

//    String listProfitPctJsonStr = JSON.toJSONString(list);

//    再存在redis中
//      取出值
//          String res =   redis.get("");
//          list = JSON.parseArray(res, Class<T> clazz);


//  获取第二个字符索引的后的指定内容
//    String q = " 3|1|闪蒸法|无 处理工艺| 化纤长丝制|35-70G/㎡|100%高密度聚乙烯|包装用等|生产厂商";
//    int i2 = q.indexOf("|");
//    int i3 = q.indexOf("|", i2 + 1); 第一个字符索引后加1
//        System.out.println(q.substring(i3 + 1, i3 + 16));




//    Object 转 map
//    public static Map<String, Object> objectToMap(Object obj) {
//        String jsonStr = JSONObject.toJSONString(obj);
//        return JSONObject.parseObject(jsonStr);
//    }
//
//    //List<T> --> List<Map<String, Object>>
//    public static <T> List<Map<String, Object>> objectList2ListMap(List<T> objectList) throws Exception {
//        ArrayList<Map<String, Object>> resultList = new ArrayList<>();
//        Map<String, Object> map = new HashMap<>();
//        for (T t : objectList) {
//            resultList.add(objectToMap(t));
//        }
//        return resultList;
//    }
}