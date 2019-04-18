package quick.pager.shop.utils;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StrUtils {

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    private static final String TABLE_PREFIX = "t_";

    /**
     * 下划线转驼峰
     */
    public static String capitalize2CamelCase(String tableName) {

        tableName = delTablePrefix(tableName).toLowerCase();

        Matcher matcher = linePattern.matcher(tableName);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * hello -> Hello
     * 字符串首字母大写
     *
     * @param dest 目标字符串
     */
    public static String upperCase(String dest) {
        char[] cs = dest.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);
    }


    /**
     * 下划线转驼峰式，首字母大写
     *
     * @param dest dest
     */
    public static String toUpperCase(String dest) {

        dest = delTablePrefix(dest);

        String[] split = dest.split("_");

        StringBuilder builder = new StringBuilder();
        for (String src : split) {
            builder.append(upperCase(src));
        }

        return builder.toString();
    }

    /**
     * 如果字符串是以 <code>t_</code>为前缀，则移除
     * t_user_order -> user_order
     *
     * @param tableName 字符串
     */
    public static String delTablePrefix(String tableName) {
        if (tableName.startsWith(TABLE_PREFIX)) {
            tableName = tableName.substring(TABLE_PREFIX.length());
        }
        return tableName;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(capitalize2CamelCase("t_user_order"));
        System.out.println(upperCase("user"));
        System.out.println(toUpperCase("t_user_order"));
        System.out.println(toUpperCase("user_order"));


    }
}
