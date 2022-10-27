package ClassDemo;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class ErrorMsg {
    //成功
    public static int SUCCESS = 0;
    //错误
    public static int ERROR = -1;
    //警告
    public static int WARNING = 1;

    private int code;
    private String message;
    private JSONObject fields;
    private Map fieldMap;//Maq结构特殊时间使用

    public Map getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map fieldMap) {
        this.fieldMap = fieldMap;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getFields() {
        return fields;
    }

    public void setFields(JSONObject fields) {
        this.fields = fields;
    }

    public ErrorMsg() {
    }

    public ErrorMsg(int code, String message, Map fieldMap) {
        this.code = code;
        this.message = message;
        this.fieldMap = fieldMap;
    }

    /**
     * 错误返回
     *
     * @return
     */
    public static ErrorMsg error(String message) {
        return new ErrorMsg(-1, message, null);
    }

    /**
     * 成功返回
     *
     * @return
     */
    public static ErrorMsg success(String message, Map fieldMap) {
        return new ErrorMsg(0, message, fieldMap);
    }

    /**
     * 成功返回
     *
     * @return
     */
    public static ErrorMsg success(String message) {
        return new ErrorMsg(0, message, null);
    }

}