package quick.pager.common.utils;

import java.time.DateTimeException;
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
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(dateTime);
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
     * 加 年
     */
    public Date plusYears(LocalDateTime dateTime, long years) {
        return Date.from(dateTime.plusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 月
     */
    public Date plusMonths(LocalDateTime dateTime, long months) {
        return Date.from(dateTime.plusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 周
     */
    public Date plusWeeks(LocalDateTime dateTime, long weeks) {
        return Date.from(dateTime.plusWeeks(weeks).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 天
     */
    public Date plusDays(LocalDateTime dateTime, long days) {
        return Date.from(dateTime.plusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 秒
     */
    public Date plusSeconds(LocalDateTime dateTime, long seconds) {
        return Date.from(dateTime.plusSeconds(seconds).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 加 分
     */
    public Date plusMinutes(LocalDateTime dateTime, long minutes) {
        return Date.from(dateTime.plusMinutes(minutes).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 年
     */
    public Date minusYears(LocalDateTime dateTime, long years) {
        return Date.from(dateTime.minusYears(years).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 月
     */
    public Date minusMonths(LocalDateTime dateTime, long months) {
        return Date.from(dateTime.minusMonths(months).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 周
     */
    public Date minusWeeks(LocalDateTime dateTime, long weeks) {
        return Date.from(dateTime.minusWeeks(weeks).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 天
     */
    public Date minusDays(LocalDateTime dateTime, long days) {
        return Date.from(dateTime.minusDays(days).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 时
     */
    public Date minusHours(LocalDateTime dateTime, long hours) {
        return Date.from(dateTime.minusHours(hours).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 分
     */
    public Date minusMinutes(LocalDateTime dateTime, long minutes) {
        return Date.from(dateTime.minusMinutes(minutes).atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 减 秒
     */
    public Date minusSeconds(LocalDateTime dateTime, long seconds) {
        return Date.from(dateTime.minusSeconds(seconds).atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) {
        System.out.println(DateUtils.now());

        System.out.println(DateUtils.parse("2019-08-08 23:30:00", "yyyy-MM-dd HH:mm:ss"));


    }
}
