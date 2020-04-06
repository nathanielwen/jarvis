package com.wonqee.jarvis.util;


import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created by Wing on 20/4/6.
 */
public class DateUtil extends DateUtils {

    public static final String COMMON_FORMAT = "yyyy/MM/dd";

    public static Date valueOf(String str, String format) {
        try {
            return parseDate(str, format);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
