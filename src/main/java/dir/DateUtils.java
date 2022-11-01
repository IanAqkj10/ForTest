package dir;


import org.apache.commons.lang.StringUtils;

import java.beans.PropertyEditorSupport;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * 类描述：时间操作定义类
 *
 * @version 1.0
 * @author: 张代浩
 * @date： 日期：2012-12-8 时间：下午12:15:03
 */
public class DateUtils extends PropertyEditorSupport {
    // 各种时间格式
    public static final SimpleDateFormat date_sdf = new SimpleDateFormat(
            "yyyy-MM-dd");
    // 各种时间格式
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd");

    public static final SimpleDateFormat yyMMdd = new SimpleDateFormat(
            "yyMMdd");
    public static final SimpleDateFormat YYYY = new SimpleDateFormat(
            "yyyy");
    // 各种时间格式
    public static final SimpleDateFormat date_sdf_wz = new SimpleDateFormat(
            "yyyy年MM月dd日");
    public static final SimpleDateFormat time_sdf = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat yyyymmddhhmmss = new SimpleDateFormat(
            "yyyyMMddHHmmss");
    public static final SimpleDateFormat short_time_sdf = new SimpleDateFormat(
            "HH:mm");
    public static final SimpleDateFormat datetimeFormat = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat MONTH = new SimpleDateFormat("yyyy-MM");

    public static final SimpleDateFormat CN_DATE = new SimpleDateFormat("yyyy年MM月dd日");


    // 各种时间格式
    public static final SimpleDateFormat yyyymm = new SimpleDateFormat("yyyyMM");
    // 以毫秒表示的时间
    private static final long DAY_IN_MILLIS = 24 * 3600 * 1000;
    private static final long HOUR_IN_MILLIS = 3600 * 1000;
    private static final long MINUTE_IN_MILLIS = 60 * 1000;
    private static final long SECOND_IN_MILLIS = 1000;

    // 指定模式的时间格式
    private static SimpleDateFormat getSDFormat(String pattern) {
        return new SimpleDateFormat(pattern);
    }

    /**
     * 当前日历，这里用中国时间表示
     *
     * @return 以当地时区表示的系统当前日历
     */
    public static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    /**
     * 指定毫秒数表示的日历
     *
     * @param millis 毫秒数
     * @return 指定毫秒数表示的日历
     */
    public static Calendar getCalendar(long millis) {
        Calendar cal = Calendar.getInstance();
        // --------------------cal.setTimeInMillis(millis);
        cal.setTime(new Date(millis));
        return cal;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getDate
    // 各种方式获取的Date
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 当前日期
     *
     * @return 系统当前时间
     */
    public static Date getDate() {
        return new Date();
    }

    /**
     * 指定毫秒数表示的日期
     *
     * @param millis 毫秒数
     * @return 指定毫秒数表示的日期
     */
    public static Date getDate(long millis) {
        return new Date(millis);
    }

    /**
     * 时间戳转换为字符串
     *
     * @param time
     * @return
     */
    public static String timestamptoStr(Timestamp time) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }
        return date2Str(date_sdf);
    }

    /**
     * 时间戳转换为字符串
     *
     * @param time
     * @return
     */
    public static String timestamptoStr(Timestamp time, SimpleDateFormat sdf) {
        Date date = null;
        if (null != time) {
            date = new Date(time.getTime());
        }
        return date2Str(date, sdf);
    }

    /**
     * 字符串转换时间戳
     *
     * @param str
     * @return
     */
    public static Timestamp str2Timestamp(String str) {
        Date date = str2Date(str, date_sdf);
        return new Timestamp(date.getTime());
    }

    /**
     * 字符串转换成日期
     *
     * @param str
     * @param sdf
     * @return
     */
    public static Date str2Date(String str, SimpleDateFormat sdf) {
        if (null == str || "".equals(str)) {
            return null;
        }
        Date date = null;
        try {
            date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Boolean formatValidation(String str, SimpleDateFormat sdf) {
        if (StringUtils.isBlank(str)) {
            return Boolean.FALSE;
        }
        try {
            sdf.parse(str);
            return Boolean.TRUE;
        } catch (ParseException e) {
            return Boolean.FALSE;
        }
    }

    /**
     * 日期转换为字符串
     *
     * @return 字符串
     */
    public static String date2Str(SimpleDateFormat date_sdf) {
        Date date = getDate();
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param format
     * @return
     */
    public static String dateformat(String date, String format) {
        SimpleDateFormat sformat = new SimpleDateFormat(format);
        Date _date = null;
        try {
            _date = sformat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sformat.format(_date);
    }

    /**
     * 日期转换为字符串
     *
     * @param date 日期
     * @return 字符串
     */
    public static String date2Str(Date date, SimpleDateFormat date_sdf) {
        if (null == date) {
            return null;
        }
        return date_sdf.format(date);
    }

    /**
     * 日期转换为字符串
     *
     * @param format 日期格式
     * @return 字符串
     */
    public static String getDate(String format) {
        Date date = new Date();
        if (null == date) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 指定毫秒数的时间戳
     *
     * @param millis 毫秒数
     * @return 指定毫秒数的时间戳
     */
    public static Timestamp getTimestamp(long millis) {
        return new Timestamp(millis);
    }

    /**
     * 以字符形式表示的时间戳
     *
     * @param time 毫秒数
     * @return 以字符形式表示的时间戳
     */
    public static Timestamp getTimestamp(String time) {
        return new Timestamp(Long.parseLong(time));
    }

    public static final String parseDateToStr(final Date date, final String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 系统当前的时间戳
     *
     * @return 系统当前的时间戳
     */
    public static Timestamp getTimestamp() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 指定日期的时间戳
     *
     * @param date 指定日期
     * @return 指定日期的时间戳
     */
    public static Timestamp getTimestamp(Date date) {
        return new Timestamp(date.getTime());
    }

    /**
     * 指定日历的时间戳
     *
     * @param cal 指定日历
     * @return 指定日历的时间戳
     */
    public static Timestamp getCalendarTimestamp(Calendar cal) {
        // ---------------------return new Timestamp(cal.getTimeInMillis());
        return new Timestamp(cal.getTime().getTime());
    }

    public static Timestamp gettimestamp() {
        Date dt = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = df.format(dt);
        Timestamp buydate = Timestamp.valueOf(nowTime);
        return buydate;
    }

    // ////////////////////////////////////////////////////////////////////////////
    // getMillis
    // 各种方式获取的Millis
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 系统时间的毫秒数
     *
     * @return 系统时间的毫秒数
     */
    public static long getMillis() {
        return new Date().getTime();
    }

    /**
     * 指定日历的毫秒数
     *
     * @param cal 指定日历
     * @return 指定日历的毫秒数
     */
    public static long getMillis(Calendar cal) {
        // --------------------return cal.getTimeInMillis();
        return cal.getTime().getTime();
    }

    /**
     * 指定日期的毫秒数
     *
     * @param date 指定日期
     * @return 指定日期的毫秒数
     */
    public static long getMillis(Date date) {
        return date.getTime();
    }

    /**
     * 指定时间戳的毫秒数
     *
     * @param ts 指定时间戳
     * @return 指定时间戳的毫秒数
     */
    public static long getMillis(Timestamp ts) {
        return ts.getTime();
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatDate
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日
     *
     * @return 默认日期按“年-月-日“格式显示
     */
    public static String formatDate() {
        return date_sdf.format(getCalendar().getTime());
    }

    /**
     * 获取时间字符串
     */
    public static String getDataString(SimpleDateFormat formatstr) {
        return formatstr.format(getCalendar().getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param cal 指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Calendar cal) {
        return date_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日
     *
     * @param date 指定的日期
     * @return 指定日期按“年-月-日“格式显示
     */
    public static String formatDate(Date date) {
        return date_sdf.format(date);
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日“格式显示
     */
    public static String formatDate(long millis) {
        return date_sdf.format(new Date(millis));
    }

    /**
     * 默认日期按指定格式显示
     *
     * @param pattern 指定的格式
     * @return 默认日期按指定格式显示
     */
    public static String formatDate(String pattern) {
        return getSDFormat(pattern).format(getCalendar().getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param cal     指定的日期
     * @param pattern 指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Calendar cal, String pattern) {
        return getSDFormat(pattern).format(cal.getTime());
    }

    /**
     * 指定日期按指定格式显示
     *
     * @param date    指定的日期
     * @param pattern 指定的格式
     * @return 指定日期按指定格式显示
     */
    public static String formatDate(Date date, String pattern) {
        return getSDFormat(pattern).format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：年-月-日 时：分
     *
     * @return 默认日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime() {
        return time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(long millis) {
        return time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param cal 指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Calendar cal) {
        return time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：年-月-日 时：分
     *
     * @param date 指定的日期
     * @return 指定日期按“年-月-日 时：分“格式显示
     */
    public static String formatTime(Date date) {
        return time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // formatShortTime
    // 将日期按照一定的格式转化为字符串
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 默认方式表示的系统当前日期，具体格式：时：分
     *
     * @return 默认日期按“时：分“格式显示
     */
    public static String formatShortTime() {
        return short_time_sdf.format(getCalendar().getTime());
    }

    /**
     * 指定毫秒数表示日期的默认显示，具体格式：时：分
     *
     * @param millis 指定的毫秒数
     * @return 指定毫秒数表示日期按“时：分“格式显示
     */
    public static String formatShortTime(long millis) {
        return short_time_sdf.format(new Date(millis));
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param cal 指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Calendar cal) {
        return short_time_sdf.format(cal.getTime());
    }

    /**
     * 指定日期的默认显示，具体格式：时：分
     *
     * @param date 指定的日期
     * @return 指定日期按“时：分“格式显示
     */
    public static String formatShortTime(Date date) {
        return short_time_sdf.format(date);
    }

    // ////////////////////////////////////////////////////////////////////////////
    // parseDate
    // parseCalendar
    // parseTimestamp
    // 将字符串按照一定的格式转化为日期或时间
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Date parseDate(String src, String pattern)
            throws ParseException {
        return getSDFormat(pattern).parse(src);

    }

    /**
     * Java代码实现当前时间往前推几个XXX
     */
    public static Date dateRoll(Date date, int i, int d) {
        // 获取Calendar对象并以传进来的时间为准
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        // 将现在的时间滚动固定时长,转换为Date类型赋值
        calendar.add(i, d);
        // 转换为Date类型再赋值
        date = calendar.getTime();
        return date;
    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的日期
     * @throws ParseException
     */
    public static Calendar parseCalendar(String src, String pattern)
            throws ParseException {

        Date date = parseDate(src, pattern);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static String formatAddDate(String src, String pattern, int amount)
            throws ParseException {
        Calendar cal;
        cal = parseCalendar(src, pattern);
        cal.add(Calendar.DATE, amount);
        return formatDate(cal);
    }

    /**
     * 根据指定的格式将字符串转换成Date 如输入：2003-11-19 11:20:20将按照这个转成时间
     *
     * @param src     将要转换的原始字符窜
     * @param pattern 转换的匹配格式
     * @return 如果转换成功则返回转换后的时间戳
     * @throws ParseException
     */
    public static Timestamp parseTimestamp(String src, String pattern)
            throws ParseException {
        Date date = parseDate(src, pattern);
        return new Timestamp(date.getTime());
    }

    // ////////////////////////////////////////////////////////////////////////////
    // dateDiff
    // 计算两个日期之间的差值
    // ////////////////////////////////////////////////////////////////////////////

    /**
     * 计算两个时间之间的差值，根据标志的不同而不同
     *
     * @param flag   计算标志，表示按照年/月/日/时/分/秒等计算
     * @param calSrc 减数
     * @param calDes 被减数
     * @return 两个日期之间的差值
     */
    public static int dateDiff(char flag, Calendar calSrc, Calendar calDes) {

        long millisDiff = getMillis(calSrc) - getMillis(calDes);

        if (flag == 'y') {
            return (calSrc.get(calSrc.YEAR) - calDes.get(calDes.YEAR));
        }

        if (flag == 'd') {
            return (int) (millisDiff / DAY_IN_MILLIS);
        }

        if (flag == 'h') {
            return (int) (millisDiff / HOUR_IN_MILLIS);
        }

        if (flag == 'm') {
            return (int) (millisDiff / MINUTE_IN_MILLIS);
        }

        if (flag == 's') {
            return (int) (millisDiff / SECOND_IN_MILLIS);
        }

        return 0;
    }

    /**
     * 日期减法
     *
     * @param flag   计算标志
     * @param calDes 被减数
     * @param calSrc 减数，提前多长时间，为正整数
     * @return 计算后的日期
     */
    @SuppressWarnings("static-access")
    public static Calendar dateSubtract(char flag, Calendar calDes,
                                        Integer calSrc) {
        Calendar startTime = Calendar.getInstance();
        if (flag == 'y') {
            startTime.add(Calendar.YEAR, -calSrc);
        }

        if (flag == 'm') {
            startTime.add(Calendar.MONTH, -calSrc);
        }

        if (flag == 'd') {
            startTime.add(Calendar.DATE, -calSrc);
        }

        if (flag == 'h') {
            startTime.add(Calendar.HOUR, -calSrc);
        }
        return startTime;
    }

    @SuppressWarnings("static-access")
    public static Calendar dateAdd(char flag, Calendar calDes, Integer calSrc) {
        Calendar startTime = Calendar.getInstance();
        if (flag == 'y') {
            startTime.add(Calendar.YEAR, calSrc);
        }

        if (flag == 'm') {
            startTime.add(Calendar.MONTH, calSrc);
        }

        if (flag == 'd') {
            startTime.add(Calendar.DATE, calSrc);
        }

        if (flag == 'h') {
            startTime.add(Calendar.HOUR, calSrc);
        }
        return startTime;
    }

    @SuppressWarnings("static-access")
    public static Date addDate(Date time, int calDes, Integer calSrc) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        calendar.add(calDes, calSrc);

        return calendar.getTime();
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param smdate 较小的时间
     * @param bdate  较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date smdate, Date bdate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 计算两个日期之间的天数
     *
     * @param smdate
     * @param bdate
     * @return
     * @throws ParseException
     */
    public static int daysBetween(String smdate, String bdate)
            throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(smdate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(bdate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }

    public static int getYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(getDate());
        return calendar.get(Calendar.YEAR);
    }

    /**
     * oracleTimestamp转换为java Timestamp
     *
     * @param value
     * @return
     */
    public static Timestamp getOracleTimestamp(Object value) {
        try {
            Class clz = value.getClass();
            Method method = clz.getMethod("timestampValue", null);
            // method = clz.getMethod("timeValue", null); 时间类型
            // method = clz.getMethod("dateValue", null); 日期类型
            return (Timestamp) method.invoke(value, null);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 得到某个月后的时间
     *
     * @param time
     * @param months
     * @return
     */
    public static String getDateStrAfterMonths(Timestamp time, int months) {
        Date date = new Date(time.getTime());
        Calendar calendar = getCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + months);
        return date_sdf_wz.format(calendar.getTime());
    }

    public static int parse(String strDate) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date_sdf.parse(strDate));
        Object year = cal.get(Calendar.YEAR);
        if (year != null) {
            return Integer.valueOf(year.toString());
        } else {
            return 0;
        }
    }


    /**
     * 获取指定时间的上一个月，格式自定义
     *
     * @param date
     * @param format
     * @return
     */
    public static String getLastMonth(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1);
        return sdf.format(cal.getTime());
    }

    /**
     * 获取指定时间的一年前时间，格式自定义
     *
     * @param date
     * @param format
     * @return
     */
    public static String getLastYearDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.YEAR, -1);
        return sdf.format(cal.getTime());
    }


    /**
     * 将自符串日期转换成日期型，格式自定义
     *
     * @param date
     * @param format
     * @return
     */
    public static Date strParseDate(String date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
        }
        return null;
    }

    public static String dateToStr(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Calendar cEndTime = Calendar.getInstance();
        Calendar cStartTime = DateUtils.dateSubtract('y', cEndTime, 1);// 开始时间
        String startTime = DateUtils.date_sdf.format(cStartTime.getTime());
        // 结束时间
        String endTime = DateUtils.date_sdf.format(cEndTime.getTime());
        System.out.println(startTime);
        System.out.println(endTime);
    }

    public static Date addTimeByMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return c.getTime();
    }

    public static String addTimeStrByMonth(Date date, int month) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MONTH, month);
        return date2Str(c.getTime(), yyyymm);
    }

    /**
     * 根据date获取当前季度
     *
     * @param date
     * @return
     */
    public static int getCurrentSeasonByDate(Date date) {
        int season = 0;

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH);
        switch (month) {
            case Calendar.JANUARY:
            case Calendar.FEBRUARY:
            case Calendar.MARCH:
                season = 1;
                break;
            case Calendar.APRIL:
            case Calendar.MAY:
            case Calendar.JUNE:
                season = 2;
                break;
            case Calendar.JULY:
            case Calendar.AUGUST:
            case Calendar.SEPTEMBER:
                season = 3;
                break;
            case Calendar.OCTOBER:
            case Calendar.NOVEMBER:
            case Calendar.DECEMBER:
                season = 4;
                break;
            default:
                break;
        }
//        System.out.println("当前季度为:第" + season + "季度");
        return season;
    }


    /**
     * 获取当前时间上个季度
     *
     * @param date
     * @return
     */
    public static int getLastSeasonByDate(Date date) {
        int lastSeason = 0;
        int currentSeason = getCurrentSeasonByDate(date);
        if (currentSeason == 1) {
            lastSeason = 4;
        } else {
            lastSeason = currentSeason - 1;
        }
//        System.out.println("上个季度为第:" + lastSeason + "季度");
        return lastSeason;
    }

    /**
     * 日期距离当前日期还有多少天
     * <p>
     * date 时间
     */
    public static long getDaysBetween(Date date) {
        Date now = new Date();
        long daysBetween = (date.getTime() - now.getTime() + 1000000) / (60 * 60 * 24 * 1000);
        return daysBetween;
    }

    /**
     * 获取当前时间几天后的时间
     * <p>
     * date 时间
     */
    public static Date getDateAfterDays(int days) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前时间X分钟前的时间
     * <p>
     * date 时间
     */
    public static Date getDateBeforeMinutes(int minute) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, -minute);
        date = calendar.getTime();
        return date;
    }


    /**
     * 获取当前时间X分钟后的时间
     * <p>
     * date 时间
     */
    public static Date getDateAfterMinutes(int minute) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取某一时间X分钟后的时间
     * <p>
     * date 时间
     */
    public static Date getDateAfterMinutes(Date date, int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取某一时间几天后的时间
     * <p>
     * date 时间
     */
    public static Date getDateAfterDays(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, days);
        date = calendar.getTime();
        return date;
    }

    /**
     * 获取当前时间.yyyy-MM-dd HH:mm:ss
     *
     * @return
     * @throws ParseException
     */
    public static String getCurtimeStr() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        return df.format(new Date());
    }

    /**
     * 获取当前时间.yyyy-MM-dd
     *
     * @return
     * @throws ParseException
     */
    public static String getCurtimeStr1() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
        return df.format(new Date());
    }

    /**
     * 获取当前整点时间字符串
     *
     * @return
     */
    public static String getIntegralTime() {
        String date = DateUtils.getCurtimeStr1();
        Calendar cal = DateUtils.getCalendar();
        int h = cal.get(Calendar.HOUR_OF_DAY);
        System.out.println(date + " " + h + ":00:00");
        return date + " " + h + ":00:00";
    }


    /**
     * 获取当前整点时间字符串
     *
     * @return
     */
    public static String getIntegralTimeByDate(Date date) {
        String format = getSDFormat("yyyy-MM-dd").format(date);
        Calendar cal = DateUtils.getCalendar();
        return format + " " + "00:00:00";
    }

    /**
     * 获取当天整点时间集合
     *
     * @return
     */
    public static List<String> getTodayIntegralTimes() {
        String date = DateUtils.getCurtimeStr1();
        Calendar cal = DateUtils.getCalendar();
        int h = cal.get(Calendar.HOUR_OF_DAY);
        List<String> todayIntegralTimes = new ArrayList<String>();
        for (int i = 0; i <= h; i++) {
            String integralTime = date + " " + i + ":00:00";
            todayIntegralTimes.add(integralTime);
        }
        return todayIntegralTimes;
    }

    /**
     * 比较两个时间大小 .
     *
     * @param time1 时间1 格式HH:mm
     * @param time2 时间1 格式HH:mm
     * @return 0相等，1 时间1大于时间2，-1 时间1小于时间2
     * @throws ParseException
     */
    public static int compareTimeHHmm(String time1, String time2) {
        int res = 0;
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = time_sdf.parse("2000-01-01 " + time1);
            date2 = time_sdf.parse("2000-01-01 " + time2);
            res = date1.compareTo(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取startDate日期后month月的日期
     *
     * @param date  开始日期
     * @param month 几个月后
     * @return
     */
    public static String getMonthDate(String date, int month) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startDate = formatter.parse(date);
        LocalDateTime localDateTime = startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime().plusMonths(month);
        Date dateNow = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return formatter.format(dateNow);
    }

    /**
     * 将给定日期转换为UNIX系统时间戳
     *
     * @param time
     * @return
     */
    public static String time2UnixTime(Date time) {
        long epoch = time.getTime();
        String res = epoch + "";
        return res;
    }

    /**
     * 获取两个日期之间的所有日期集合yyyyMMdd
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> splitDateList(Date startDate, Date endDate) {
        List<String> listDate = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                listDate.add(yyyyMMdd.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return listDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDate;
    }

    /**
     * 获取两个日期之间的所有日期集合yyyy-MM-dd
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static List<String> splitDateList1(Date startDate, Date endDate) {
        List<String> listDate = new ArrayList<>();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            while (calendar.getTime().before(endDate) || calendar.getTime().equals(endDate)) {
                listDate.add(date_sdf.format(calendar.getTime()));
                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }
            return listDate;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDate;
    }

    /**
     * 判断是否整点
     *
     * @param date
     * @return
     */
    public static Boolean decideWholePoint(Date date) {
        Boolean flag = false;
        String strTime = DateUtils.formatDate(date, "mm:ss");
        if (strTime.equals("00:00")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 获取几个小时前的整点时间集合
     *
     * @param calendar
     * @param count
     * @return
     */
    public static List<String> getBeforeWholeTime(Calendar calendar, int count) {
        List<String> wholeTimes = new ArrayList<String>();
        Date date = calendar.getTime();
        String time = DateUtils.formatDate(date, "yyyy-MM-dd HH:mm:ss");
        wholeTimes.add(time);
        for (int i = 1; i < count; i++) {
            calendar.add(Calendar.HOUR, -1);
            Date date1 = calendar.getTime();
            String time1 = DateUtils.formatDate(date1, "yyyy-MM-dd HH:mm:ss");
            wholeTimes.add(time1);
        }
        return wholeTimes;
    }

    /**
     * 获取昨天日期字符串(指定格式)
     *
     * @param format
     * @return
     */
    public static String getYesterday(String format) {
        Date today = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String yesterday = simpleDateFormat.format(today);//获取昨天日期
        return yesterday;
    }

    /**
     * 获取两个时间段之间的分钟
     * @param begin
     * @param end
     * @return
     * @throws ParseException
     */
    public static List<String> getMinuteBetweenTwoDate(Object begin,
                                                       Object end) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String beginDate;
        String endDate;
        if (begin instanceof Date){
            beginDate = sdf.format(begin);
            endDate = sdf.format(end);
        }else{
            beginDate = begin.toString();
            endDate = end.toString();
        }
        List<String> lDate = new ArrayList<String>();
        lDate.add(beginDate + ":" + "00");// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(sdf.parse(beginDate));
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.MINUTE, 1);
            // 测试此日期是否在指定日期之后
            if (sdf.parse(endDate).after(cal.getTime())) {
                lDate.add(sdf.format(cal.getTime()) + ":" + "00");
            } else {
                break;
            }
        }
        lDate.add(endDate + ":" +"00");// 把结束时间加入集合
        return lDate;
    }


    /**
     * 获取两个时间段之间的分钟
     * @param begin
     * @param end
     * @return
     * @throws ParseException
     */
    public static List<String> get5MinuteBetweenTwoDate(Object begin,
                                                       Object end) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String beginDate;
        String endDate;
        if (begin instanceof Date){
            beginDate = sdf.format(begin);
            endDate = sdf.format(end);
        }else{
            beginDate = begin.toString();
            endDate = end.toString();
        }
        List<String> lDate = new ArrayList<String>();
        lDate.add(beginDate + ":" + "00");// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(sdf.parse(beginDate));
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.MINUTE, 10);
            // 测试此日期是否在指定日期之后
            if (sdf.parse(endDate).after(cal.getTime())) {
                lDate.add(sdf.format(cal.getTime()) + ":" + "00");
            } else {
                break;
            }
        }
        lDate.add(endDate + ":" +"00");// 把结束时间加入集合
        return lDate;
    }

    /**
     * 获取Date 当天的0点时间
     * @return
     */
    public static  Date getDateZeroTime(Object inputDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date formatDate = null;
        if (inputDate instanceof Date){
            formatDate=(Date) inputDate;
        }else if(inputDate instanceof String){
            formatDate = sdf.parse(inputDate.toString());
        }
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(formatDate);
        aCalendar.set(Calendar.HOUR_OF_DAY, 0);
        aCalendar.set(Calendar.MINUTE, 0);
        aCalendar.set(Calendar.SECOND, 0);
        Date z = aCalendar.getTime();
        return z;
    }

    public static String getPreviousWeekSunday() {

        int weeks = -1;

        int mondayPlus = getMondayPlus();

        GregorianCalendar currentDate = new GregorianCalendar();

        currentDate.add(5, mondayPlus + weeks);

        Date monday = currentDate.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String preMonday = sdf.format(monday);

        return preMonday;
    }

    public static String getPreviousWeekday() {
        int week = -1;

        int mondayPlus = getMondayPlus();

        GregorianCalendar currentDate = new GregorianCalendar();

        currentDate.add(5, mondayPlus + 7 * week);

        Date monday = currentDate.getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String preMonday = sdf.format(monday);

        return preMonday;
    }

    public static int getMondayPlus() {
        Calendar cd = Calendar.getInstance();

        int dayOfWeek = cd.get(7) - 1;

        if (dayOfWeek == 1) {
            return 0;
        }

        return (1 - dayOfWeek);
    }

    /**
     *  日期相减
     * @param date 原来的日期
     * @param days 减去的天数
     * @return
     */
    public static Date subDate(Date date, Integer days) {
        return helpDate(date, 5, days);
    }

    public static Date helpDate(Date date, Integer field, Integer amount) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static String ymrToCn(String date) {
        try {
            Date parse = yyyyMMdd.parse(date);
            return CN_DATE.format(parse);
        } catch (ParseException e) {
            return null;
        }
    }

}