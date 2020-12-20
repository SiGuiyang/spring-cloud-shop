package quick.pager.shop.utils;

import java.time.LocalDate;
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
    /**
     * 标准日期格式：yyyy-MM-dd
     */
    public final static String NORM_DATE_PATTERN = "yyyy-MM-dd";

    /**
     * 标准时间格式：HH:mm:ss
     */
    public final static String NORM_TIME_PATTERN = "HH:mm:ss";

    /**
     * 标准日期时间格式，精确到分：yyyy-MM-dd HH:mm
     */
    public final static String NORM_DATETIME_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";

    /**
     * 标准日期时间格式，精确到秒：yyyy-MM-dd HH:mm:ss
     */
    public final static String NORM_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 标准日期时间格式，精确到毫秒：yyyy-MM-dd HH:mm:ss.SSS
     */
    public final static String NORM_DATETIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.SSS";

    //-------------------------------------------------------------------------------------------------------------------------------- Pure
    /**
     * 标准日期格式：yyyyMMdd
     */
    public final static String PURE_DATE_PATTERN = "yyyyMMdd";
    /**
     * 标准日期格式：yyyyMM
     */
    public final static String PURE_MONTH_PATTERN = "yyyyMM";
    /**
     * 标准日期格式：mm:ss
     */
    public final static String PURE_MINUTES_PATTERN = "mm:ss";

    /**
     * 标准日期格式：HHmmss
     */
    public final static String PURE_TIME_PATTERN = "HHmmss";

    /**
     * 标准日期格式：yyyyMMddHHmmss
     */
    public final static String PURE_DATETIME_PATTERN = "yyyyMMddHHmmss";

    /**
     * 标准日期格式：yyyyMMddHHmmssSSS
     */
    public final static String PURE_DATETIME_MS_PATTERN = "yyyyMMddHHmmssSSS";

    //-------------------------------------------------------------------------------------------------------------------------------- Others
    /**
     * HTTP头中日期时间格式：EEE, dd MMM yyyy HH:mm:ss z
     */
    public final static String HTTP_DATETIME_PATTERN = "EEE, dd MMM yyyy HH:mm:ss z";

    /**
     * JDK中日期时间格式：EEE MMM dd HH:mm:ss zzz yyyy
     */
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
    public static String formatTimeDate(final LocalDateTime dateTime) {
        return DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).format(dateTime);
    }

    /**
     * 根据不同的 格式化规则格式时间样式
     *
     * @param dateTime 时间
     * @param pattern  格式化规则
     */
    public static String format(final LocalDateTime dateTime, final String pattern) {
        return DateTimeFormatter.ofPattern(pattern).format(dateTime);
    }


    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     * @param pattern   转换格式
     */
    public static Date parse(final String parseTime, final String pattern) {

        LocalDateTime dateTime = LocalDateTime.from(DateTimeFormatter.ofPattern(pattern).parse(parseTime));

        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     */
    public static LocalDateTime parseTime(final String parseTime) {
        return LocalDateTime.from(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).parse(parseTime));
    }


    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     */
    public static LocalDateTime parseTime(final String parseTime, final String pattern) {
        return LocalDateTime.from(DateTimeFormatter.ofPattern(pattern).parse(parseTime));
    }

    /**
     * 转换时间
     */
    public static LocalDateTime parseLocalDateTime(final Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 转换时间
     */
    public static LocalDate parseLocalDate(final Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * 转换时间
     *
     * @param parseTime 时间内容
     */
    public static Date parseDateTime(final String parseTime) {

        LocalDateTime dateTime = LocalDateTime.from(DateTimeFormatter.ofPattern(NORM_DATETIME_PATTERN).parse(parseTime));

        return Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 年
     */
    public static LocalDateTime plusYears(final LocalDateTime dateTime, final long years) {
        return dateTime.plusYears(years).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 加 月
     */
    public static LocalDateTime plusMonths(final LocalDateTime dateTime, final long months) {
        return dateTime.plusMonths(months).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 加 月
     */
    public static LocalDate plusMonths(final LocalDate localDate, final long months) {
        return localDate.plusMonths(months);
    }


    /**
     * 加 周
     */
    public static LocalDateTime plusWeeks(final LocalDateTime dateTime, final long weeks) {
        return dateTime.plusWeeks(weeks).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 加 天
     */
    public static LocalDateTime plusDays(final LocalDateTime dateTime, final long days) {
        return dateTime.plusDays(days).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 加 秒
     */
    public static LocalDateTime plusSeconds(final LocalDateTime dateTime, final long seconds) {
        return dateTime.plusSeconds(seconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 加 分
     */
    public static LocalDateTime plusMinutes(final LocalDateTime dateTime, final long minutes) {
        return dateTime.plusMinutes(minutes).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 年
     */
    public static LocalDateTime minusYears(final LocalDateTime dateTime, final long years) {
        return dateTime.minusYears(years).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 月
     */
    public static LocalDateTime minusMonths(final LocalDateTime dateTime, final long months) {
        return dateTime.minusMonths(months).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 月
     */
    public static LocalDate minusMonths(final LocalDate localDate, final long months) {
        return localDate.minusMonths(months);
    }

    /**
     * 减 周
     */
    public static LocalDateTime minusWeeks(final LocalDateTime dateTime, final long weeks) {
        return dateTime.minusWeeks(weeks).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 天
     */
    public static LocalDateTime minusDays(final LocalDateTime dateTime, final long days) {
        return dateTime.minusDays(days).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 时
     */
    public static LocalDateTime minusHours(final LocalDateTime dateTime, final long hours) {
        return dateTime.minusHours(hours).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 分
     */
    public static LocalDateTime minusMinutes(final LocalDateTime dateTime, final long minutes) {
        return dateTime.minusMinutes(minutes).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 减 秒
     */
    public static LocalDateTime minusSeconds(final LocalDateTime dateTime, final long seconds) {
        return dateTime.minusSeconds(seconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.dateTime());

        System.out.println(DateUtils.parse("2019-08-08 23:30:00", "yyyy-MM-dd HH:mm:ss"));


    }
}
