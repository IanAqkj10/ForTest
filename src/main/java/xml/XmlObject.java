package xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class XmlObject {
    private static String HEAD = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";  
    private String name;  
    private Object value;  
    private List<Attribute> attributes;
    private List<XmlObject> subXmlObjects;   
    /**  
     * 根据name构造XmlObject  
     * @param name 生成xml时标签名，如name="html"，则生成xml为<html/> 
     */  
    public XmlObject(String name) {  
        this.name = name;  
    }   
    /**  
     * 获得当前对象的名称  
     * @return 返回当前对象的名称  
     */  
    public final String getName() {  
        return name;  
    }   
    /**  
     * 设置当前对象的名称  
     * @param name 给定名称  
     */  
    public final void setName(String name) {  
        this.name = name;  
    }   
    /**  
     * 获得当前对象的值  
     * @return 返回当前对象的值  
     */  
    public final Object getValue() {  
        return value;  
    }   
    /**  
     * 设置当前对象的值  
     * @param value 给定值  
     */  
    public final void setValue(Object value) {  
        this.value = value;  
    }   
    /**  
     * 为当前XmlObject添加属性  
     * @param name 属性名  
     * @param value 属性值  
     */  
    public final void setAttribute(String name, Object value) {  
        if (attributes == null) {  
            attributes = new ArrayList<Attribute>();
        }  
        Attribute attribute = null;  
        for (Attribute att : attributes) {  
            if (name.equalsIgnoreCase(att.getName())) {
                attribute = att;
                break;  
            }  
        }  
        if (attribute == null) {  
            attribute = new Attribute(name, value);  
            attributes.add(attribute);  
        } else {  
            attribute.setValue(value);  
        }  
    }   
    /**  
     * 根据属性名称获得当前XmlObject对象的属性值  
     * @param name 属性名称  
     * @return 属性值  
     */  
    public final Object getAttributeValue(String name) {  
        return getAttributeValue(name, null);  
    }   
    /**  
     * 根据属性名称获得当前XmlObject对象的属性值  
     * @param name 属性名称  
     * @param defaultValue 默认值  
     * @return 若属性存在，则返回属性值，否则返回默认值  
     */  
    public final Object getAttributeValue(String name, Object defaultValue) {  
        Attribute attribute = null;  
        for (Attribute att : attributes) {  
            if (name.equalsIgnoreCase(att.getName())) {
                attribute = att;
                break;  
            }  
        }  
        if (attribute == null) {  
            return defaultValue;  
        } else {  
            return attribute.getValue();  
        }  
    }   
    /**  
     * 为当前XmlObject对象添加子XmlObject对象  
     * @param xmlObject 给定XmlObject对象  
     */  
    public final void addSubXmlObject(XmlObject xmlObject) {  
        if (subXmlObjects == null) {  
            subXmlObjects = new ArrayList<XmlObject>();  
        }  
        subXmlObjects.add(xmlObject);  
    }   
    /**  
     * 构造当前对象的压缩XML字符串  
     *   
     * @return XML字符串  
     */  
    public final String toCompactXml() {  
        return HEAD + getNoHeadXml("", "");  
    }   
    /**  
     * 根据格式化留白("\t")和默认的行分隔符("\t")构造当前对象的XML字符串  
     *   
     * @return XML字符串  
     */  
    public String toFormatXml() {  
        return toFormatXml("\t");  
    }   
    /**  
     * 根据格式化留白和默认的行分隔符构("\n")造当前对象的XML字符串  
     *   
     * @param blank  
     *            格式化留白  
     * @return XML字符串  
     */  
    protected final String toFormatXml(String blank) {  
        return HEAD + "\n" + getNoHeadXml(blank, "\n");  
    }   
    /**  
     * 根据格式化留白和行分隔符构造当前对象的无头的XML字符串  
     *   
     * @param blank  
     *            格式化留白  
     * @param split  
     *            行分隔符  
     * @return 无头的XML字符串  
     */  
    protected final String getNoHeadXml(String blank, String split) {  
        return getNoHeadXml(blank, split, 0);  
    }   
    private final String getNoHeadXml(String blank, String split, int count) {  
        String blanks = "";  
        for (int i = 0; i < count; i++) {  
            blanks += blank;  
        }  
        StringBuffer sb = new StringBuffer();  
        sb.append(blanks + "<" + name);  
        if (attributes != null) {  
            Iterator<Attribute> iterator = attributes.iterator();
            while (iterator.hasNext()) {  
                Attribute attribute = iterator.next();  
                sb.append(" " + attribute.getName() + "=\""  
                        + attribute.getValue() + "\"");  
            }  
        }  
        if (subXmlObjects == null) {  
            if (value == null) {  
                sb.append("/>" + split);  
            } else {  
                sb.append(">");  
                sb.append(value);  
                sb.append("</" + name + ">" + split);  
            }  
        } else {  
            sb.append(">" + split);  
            Iterator<XmlObject> iterator = subXmlObjects.iterator();  
            count += 1;  
            while (iterator.hasNext()) {  
                XmlObject xmlObject = iterator.next();  
                sb.append(xmlObject.getNoHeadXml(blank, split, count));  
            }  
            sb.append(blanks + "</" + name + ">" + split);  
        }  
        return sb.toString();  
    }   
    class Attribute {  
        private String name;  
        private Object value;  
 
        public Attribute(String name, Object value) {  
            this.name = name;  
            this.value = value;  
        }   
        public String getName() {  
            return name;  
        }   
        public void setName(String name) {  
            this.name = name;  
        }   
        public Object getValue() {  
            return value;  
        }   
        public void setValue(Object value) {  
            this.value = value;  
        }  
    }  
} 