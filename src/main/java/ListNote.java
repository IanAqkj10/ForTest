

/**
 * @Description:
 * @author:ljh
 * @date:2022/4/29 9:56
 */

public class ListNote {
//    //1.对int类型list进行求和
//    Integer[] integerArray = {1, 3, 5, 10, 18};
//
//    List<Integer> list = new ArrayList<>(Arrays.asList(integerArray));
//
//    IntSummaryStatistics summaryStatistics = list.stream().mapToInt((s) -> s).summaryStatistics();
//        System.out.println("总和：" + summaryStatistics.getSum());
//        System.out.println("平均数：" + summaryStatistics.getAverage());
//        System.out.println("总个数：" + summaryStatistics.getCount());
//        System.out.println("最大值：" + summaryStatistics.getMax());
//        System.out.println("最小值：" + summaryStatistics.getMin());
//
//    //2.对list中的对象某个数值字段求和
//    List<OrderReceivablesDetail> userList = new ArrayList<>();
//    OrderReceivablesDetail user1 = new OrderReceivablesDetail();
//        user1.setCollectionRatio(10.1);//double类型
//        user1.setMoney(new BigDecimal(1000.1));//BigDecimal类型
//        userList.add(user1);
//    OrderReceivablesDetail user2 = new OrderReceivablesDetail();
//        user2.setCollectionRatio(20.1);//double类型
//        user2.setMoney(new BigDecimal(2000.1));//BigDecimal类型
//        userList.add(user2);
//    //写法1
//    double collectionRatio = userList.stream().collect(Collectors.summingDouble(OrderReceivablesDetail::getCollectionRatio));
//        System.out.println("比例总和 ：" + collectionRatio);
//    //写法2
//    double collectionRatio2 = userList.stream().mapToDouble(OrderReceivablesDetail::getCollectionRatio).sum();
//        System.out.println("比例总和2： " + collectionRatio2);
//
//    //3.对list中对象某个BigDecimal字段求和
//    BigDecimal sumMoney = userList.stream().map(OrderReceivablesDetail::getMoney).reduce(BigDecimal.ZERO,BigDecimal::add);
//        System.out.println("总金额： " + sumMoney);
//    //说明：summingDouble方法是针对double类型的
//    //summingLong  long类型
//    //summingInt   Int类型
//
//    //第二种转换法  方法
//    //mapToLong  long类型
//    //mapToDouble  double类型
//    //mapToInt     Int类型
}