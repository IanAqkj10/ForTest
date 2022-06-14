package codeNote;

/**
 * @Description:
 * @author:ljh
 * @date:2022/5/9 10:56
 */

public class ListNote {

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
}