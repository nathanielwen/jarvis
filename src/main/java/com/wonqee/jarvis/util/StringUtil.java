package com.wonqee.jarvis.util;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Wing on 20/4/5.
 */
public class StringUtil extends StringUtils {

    private static final String GROUP_NAME_REGEX = "\\?<([^>]+)>";

    private static Map<String, Pattern> cachedPatterns = new WeakHashMap<>();

    static {
        cachedPatterns.put(GROUP_NAME_REGEX, Pattern.compile(GROUP_NAME_REGEX));
    }

    private static Pattern getPatternFromCache(String regex) {
        Pattern pattern = cachedPatterns.get(regex);
        if (pattern == null) {
            pattern = Pattern.compile(regex);
            cachedPatterns.put(regex, pattern);
        }
        return pattern;
    }


    /**
     * 判断字符串是否满足正则表达式
     *
     * @param str
     * @param regex
     * @return
     */
    public static boolean isMatch(String str, String regex) {
        Pattern pattern = getPatternFromCache(regex);
        return pattern.matcher(str).find();
    }


    /**
     * 从命名捕获组中获取名称
     *
     * @param regex
     * @return
     */
    public static List<String> extraGroupNames(String regex) {

        List<String> result = new ArrayList<>();

        Pattern pattern = getPatternFromCache(GROUP_NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        while (matcher.find()) {
            result.add(matcher.group(1));
        }

        return result;
    }


    /**
     * 根据正则表达式的匹配结果，组装实例
     *
     * @param str
     * @param regex
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T buildFromRegex(String str, String regex, Class<T> clazz) {

        if (!isMatch(str, regex)) {
            return null;
        }

        try {
            T instance = clazz.newInstance();

            List<String> names = extraGroupNames(regex);

            Pattern pattern = getPatternFromCache(regex);
            Matcher matcher = pattern.matcher(str);
            matcher.find();

            for (String name : names) {
                Field field = clazz.getDeclaredField(name);
                field.setAccessible(true);
                field.set(instance, matcher.group(name));
            }

            return instance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
