package sijimoshi.dongtaidaili;

/**
 * @Description:
 * @author:ljh
 * @date:2022/8/3 14:33
 */

public class DtSmsServiceImpl implements DtSms {
    @Override
    public String send(String msg) {
        System.out.println("msg:" + msg);
        return "qaq" + msg;
    }
}