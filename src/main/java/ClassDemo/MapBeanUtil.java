package ClassDemo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class MapBeanUtil {



    private static String modelName = "com.cicdi.servertemplate.modules.baselibrary.model.";


    /**
     * 将对象装换为map
     *
     * @param bean
     * @return
     */
    public static <T> Map<String, Object> beanToMap(T bean) {

        Map<String, Object> map = new LinkedHashMap<>();  //按插入的顺序进行有序存储
        Class<?> clazz = bean.getClass();

        for (Field field : clazz.getSuperclass().getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            map.put(fieldName, value);
        }

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = null;
            try {
                value = field.get(bean);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            map.put(fieldName, value);
        }
        return map;
    }


    /**
     * 将Map对象通过反射机制转换成Bean对象
     *
     * @param map   存放数据的map对象
     * @param clazz 待转换的class
     * @return 转换后的Bean对象
     * @throws Exception 异常
     */
    public static Object mapToBean(Map<String, Object> map, Class<?> clazz) throws Exception {
        Object obj = clazz.newInstance();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String propertyName = entry.getKey();       //属性名
                Object value = entry.getValue();
                String setMethodName = "set"
                        + propertyName.substring(0, 1).toUpperCase()
                        + propertyName.substring(1);
                Field field = getClassField(clazz, propertyName);
                if (field == null)
                    continue;
                Class<?> fieldTypeClass = field.getType();
                value = convertValType(value, fieldTypeClass);
                try {
                    clazz.getMethod(setMethodName, field.getType()).invoke(obj, value);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }


    /**
     * 获取指定字段名称查找在class中的对应的Field对象(包括查找父类)
     *
     * @param clazz     指定的class
     * @param fieldName 字段名称
     * @return Field对象
     */
    public static Field getClassField(Class<?> clazz, String fieldName) {
        if (Object.class.getName().equals(clazz.getName())) {
            return null;
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getName().equals(fieldName)) {
                return field;
            }
        }
        return null;
    }

    /**
     * 将Object类型的值，转换成bean对象属性里对应的类型值
     *
     * @param value          Object对象值
     * @param fieldTypeClass 属性的类型
     * @return 转换后的值
     */
    public static Object convertValType(Object value, Class<?> fieldTypeClass) {
        Object retVal = null;
        if (Long.class.getName().equals(fieldTypeClass.getName())
                || long.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Long.parseLong(value.toString());
        } else if (Integer.class.getName().equals(fieldTypeClass.getName())
                || int.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Integer.parseInt(value.toString());
        } else if (Float.class.getName().equals(fieldTypeClass.getName())
                || float.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Float.parseFloat(value.toString());
        } else if (Double.class.getName().equals(fieldTypeClass.getName())
                || double.class.getName().equals(fieldTypeClass.getName())) {
            retVal = Double.parseDouble(value.toString());
        } else {
            retVal = value;
        }
        return retVal;
    }


    /**
     * 不同的输入map，返回不同Object
     *
     * @param tableName
     * @param map
     * @return
     */
    public static Object returnObj(String tableName, Map map) {
        Object obj = null;
        Class<?> aClass = null;
        try {
            //利用反射，通过完整类名找到类对象
            aClass = Class.forName(modelName + tableName).newInstance().getClass();
            obj = MapBeanUtil.mapToBean(map, aClass);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 原表转换备份表
     * OPERATION：操作标志0：插入，1：更新，2：删除
     */
    public static Map transMap(Object obj, Object objBak, String operation) {
        Map<String, Object> map1 = MapBeanUtil.beanToMap(obj); //主键id有值了
        String id = (String) map1.entrySet().iterator().next().getValue(); //原表主键
        Map<String, Object> map2 = MapBeanUtil.beanToMap(objBak); //备份表map结构,有顺序
        int pos = 0;
        for (Iterator<String> iterator = map2.keySet().iterator(); iterator.hasNext(); pos++) {
            String keyId = iterator.next();
            if (pos == 1) {  //备份表中的外键,取map中的第二个元素
                map2.put(keyId, id);
            }
            if (keyId.equals("isNew")) {
                map2.put(keyId, "1");
            } else if (keyId.equals("operation")) {
                if (operation.equals("insert")) {
                    map2.put(keyId, "0");
                } else if (operation.equals("update")) {
                    map2.put(keyId, "1");
                } else if (operation.equals("delete")) {
                    map2.put(keyId, "2");
                }

            } else if (keyId.equals("batchTime")) {
                map2.put(keyId, new Date());
            }
        }
        return map2;
    }

    /**
     *
     */
    public static Object getValue(String type, String name, Object model) {
        Object value = null;
        try {
            if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                Method m = model.getClass().getMethod("get" + name);
                value = (String) m.invoke(model); // 调用getter方法获取属性值
                if (value == null) {
                    m = model.getClass().getMethod("set" + name, String.class);
                    m.invoke(model, "");
                }
            }
            if (type.equals("class java.lang.Integer")) {
                Method m = model.getClass().getMethod("get" + name);
                value = (Integer) m.invoke(model);
                if (value == null) {
                    m = model.getClass().getMethod("set" + name, Integer.class);
                    m.invoke(model, 0);
                }
            }
            if (type.equals("class java.lang.Boolean")) {
                Method m = model.getClass().getMethod("get" + name);
                value = (Boolean) m.invoke(model);
                if (value == null) {
                    m = model.getClass().getMethod("set" + name, Boolean.class);
                    m.invoke(model, false);
                }
            }
            if (type.equals("class java.util.Date")) {
                Method m = model.getClass().getMethod("get" + name);
                value = (Date) m.invoke(model);
                if (value == null) {
                    m = model.getClass().getMethod("set" + name, Date.class);
                    m.invoke(model, new Date());
                }
            }
            // 如果有需要,可以仿照上面继续进行扩充,再增加对其它类型的判断
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。</br>
     * 例如：HelloWorld->HELLO_WORLD
     *
     * @param name 转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String underscoreName(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

}