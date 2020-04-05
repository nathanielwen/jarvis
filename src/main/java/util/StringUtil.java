package util;

import org.apache.commons.lang.StringUtils;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

/**
 * Created by Wing on 20/4/5.
 */
public class StringUtil extends StringUtils {

    private static Map<String, Pattern> cachedPatterns = new WeakHashMap<>();

    /**
     * 判断字符串是否满足正则表达式
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean isMatch(String str, String regex) {
        Pattern pattern = cachedPatterns.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            cachedPatterns.put(regex, pattern);
        }
        return pattern.matcher(str).find();
    }

    public static void main(String[] args) {
        System.out.println(
                StringUtil.isMatch("2019/12/30", "\\d{4}/\\d{2}/\\d{2}")
        );

        System.out.println(
                StringUtil.isMatch("2019/12/30", "\\d{4}-\\d{2}-\\d{2}")
        );
    }
}
