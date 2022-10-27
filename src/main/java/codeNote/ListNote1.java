package codeNote;

/**
 * @Description:
 * @author:ljh
 * @date:2022/5/9 10:56
 */

public class ListNote1 {

    /** return boolean
     * 判断list中某个属性是否为空
     list.stream().filter(l -> StringUtils.isBlank(l.get属性())).findAny().isPresent()
     */

    /** return boolean
     * 判断list中对象的某个属性是否重复

     List<属性类型> collect = list.stream().map(Object::get属性).distinct().collect(Collectors.toList());
     collect.size() != list.size()
     */

    /**
     * 计算list中的bigdecimal总和
     *
     * list.stream().map(Entity::get属性).reduce(BigDecimal.ZERO, BigDecimal::add);
     */

    /**
     * //定义集合
     * List<PrescriptionDTO> entryValue = entry.getValue();
     *
     * //数据处理
     * BigDecimal sum = entryValue.stream().map(PrescriptionDTO::getMoney).
     * filter(Objects::nonNull).reduce(BigDecimal.ZERO, BigDecimal::add);
     *
     * 函数拆解分析：
     * 1. map(PrescriptionDTO::getMoney) ----获取集合里对象的指定字段
     * 2. filter(Objects::nonNull) ----只获取money字段非空的对象
     * 3. reduce(BigDecimal.ZERO, BigDecimal::add) ----对money字段进行求和
     */

    /**
     * 筛选指定list内容
     * T t = list.stream().filter(a-> 条件true).findFirst().get();
     *
     */


    /**
     * 把List1和List2中id重复的Student对象的name取出来：
     * ist<String> strings = list1.stream().map(Student::getId).filter(map2::containsKey).map(map2::get).map(Student::getName).collect(Collectors.toList());
     * System.out.println(strings);// 输出 [学生2, 学生3]
     */


    /**
     * 过滤去重，两个List<Student>
     * Map<String, Student> map2 = list2.stream().collect(Collectors.toMap(Student::getId,Function.identity()));
     */


    /**
     * 把Student集合按照group分组到map中
     * Map<String, List<Student>> map = list.stream().collect(Collectors.groupingBy(Student::getGroup));
     */


    /**
     * 3.想获得一个id和name对应的Map<String, String>
     * Map<String, String> map = list.stream().collect(Collectors.toMap(Student::getId, e->e.getName()==null?"":e.getName()));
     */


    /**
     * 将文件以name进行分组 取最大时间的  map(name=FileComVo(max(Time)))
     *         Map<String, FileComVo> map =
     *                 voLIst.parallelStream().collect(
     *                         Collectors.groupingBy(FileComVo::getName,
     *                                 Collectors.collectingAndThen(
     *                                         Collectors.reducing((a, b) -> a.getTime() > b.getTime() ? a : b), Optional::get)));
     *
     */
}