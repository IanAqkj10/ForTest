package date;

import java.util.Date;

/**
 * @Description:
 * @author:ljh
 * @date:2022/11/2 9:32
 */

public class DateMain {
    public static void main(String[] args) {

        Date currDate = new Date();
        String yes = DateUtils.date2Str(DateUtils.subDate(currDate, -1), DateUtils.yyyyMMdd);
        String tableName = "tb_message_history_rtd_" + yes;
        System.out.println(tableName);
    }

}