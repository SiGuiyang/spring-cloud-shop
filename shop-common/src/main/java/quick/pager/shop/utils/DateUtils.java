package quick.pager.shop.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 时间操作工具类
 *
 * @author siguiyang
 */
public class DateUtils {

    //-------------------------------------------------------------------------------------------------------------------------------- Normal
    /** 标准日期格式：yyyy-MM-dd */
    public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";

    /** 标准时间格式：HH:mm:ss */
    public final static String NORM_TIME_PATTERN = "HH:mm:ss";

    /** 标准日期时间格式，精确到分：yyyy-MM-dd HH:mm */
    public final static String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

    /** 标准日期时间格式，精确到秒：yyyy-MM-dd HH:mm:ss */
    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /** 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS */
    public final static String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    //-------------------------------------------------------------------------------------------------------------------------------- Pure
    /** 标准日期格式：yyyyMMdd */
    public final static String PURE_DATE_PATTERN = "yyyyMMdd";

    /** 标准日期格式：HHmmss */
    public final static String PURE_TIME_PATTERN = "HHmmss";

    /** 标准日期格式：yyyyMMddHHmmss */
    public final static String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";

    /** 标准日期格式：yyyyMMddHHmmssSSS */
    public final static String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";

    //-------------------------------------------------------------------------------------------------------------------------------- Others
    /** HTTP头中日期时间格式：EEE, dd MMM yyyy HH:mm:ss z */
    public final static String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

    /** JDK中日期时间格式：EEE MMM dd HH:mm:ss zzz yyyy */
    public final static String JDK_DATETIME_PATTERN = "EEE MMM dd HH:mm:ss zzz yyyy";

    private DateUtils() {
    }


    /**
     * 当前时间
     */
    public static LocalDateTime dateTime() {
        return LocalDateTime.now();
    }

    /**
     * 获取当前时间
     */
    public static Date now() {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 时间格式化 yyyy-MM-dd HH:mm:ss
     *
     * @param dateTime 时间
     */
    public static String formatTimeDate(LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).format(dateTime);
    }

    /**
     * 根据不同的 格式化规则格式时间样式
     *
     * @param dateTime 时间
     * @param pattern  格式化规则
     */
    public static String format(LocalDateTime dateTime, String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }


    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     * @param pattern   转换格式
     */
    public static Date parse(String parseTime, String pattern) {

        LocalDateTime dateTime = LocalDateTime.from(DateTimeFormatter.ofPattern(pattern).parse(parseTime));

        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     */
    public static Date parseDateTime(String parseTime) {

        LocalDateTime dateTime = LocalDateTime.from(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).parse(parseTime));

        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 年
     */
    public static Date plusYears(LocalDateTime dateTime, long years) {
        return Date.from(dateTime.plusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 月
     */
    public static Date plusMonths(LocalDateTime dateTime, long months) {
        return Date.from(dateTime.plusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 周
     */
    public static Date plusWeeks(LocalDateTime dateTime, long weeks) {
        return Date.from(dateTime.plusWeeks(weeks).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 天
     */
    public static Date plusDays(LocalDateTime dateTime, long days) {
        return Date.from(dateTime.plusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 秒
     */
    public static Date plusSeconds(LocalDateTime dateTime, long seconds) {
        return Date.from(dateTime.plusSeconds(seconds).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 分
     */
    public static Date plusMinutes(LocalDateTime dateTime, long minutes) {
        return Date.from(dateTime.plusMinutes(minutes).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 年
     */
    public static Date minusYears(LocalDateTime dateTime, long years) {
        return Date.from(dateTime.minusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 月
     */
    public static Date minusMonths(LocalDateTime dateTime, long months) {
        return Date.from(dateTime.minusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 周
     */
    public static Date minusWeeks(LocalDateTime dateTime, long weeks) {
        return Date.from(dateTime.minusWeeks(weeks).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 天
     */
    public static Date minusDays(LocalDateTime dateTime, long days) {
        return Date.from(dateTime.minusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 时
     */
    public static Date minusHours(LocalDateTime dateTime, long hours) {
        return Date.from(dateTime.minusHours(hours).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 分
     */
    public static Date minusMinutes(LocalDateTime dateTime, long minutes) {
        return Date.from(dateTime.minusMinutes(minutes).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 秒
     */
    public static Date minusSeconds(LocalDateTime dateTime, long seconds) {
        return Date.from(dateTime.minusSeconds(seconds).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.dateTime());

        System.out.println(DateUtils.parse("2019-08-08 23:30:00", "yyyy-MM-dd HH:mm:ss"));


    }
}
