package com.wonqee.jarvis.util;

import com.wonqee.jarvis.domain.Record;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Wing on 20/4/5.
 */
public class StringUtilTest {

    @Test
    public void testMatch() {
        String str = "2019/12/30";
        String regex = "\\d{4}/\\d{2}/\\d{2}";
        Assert.assertTrue(StringUtil.isMatch(str, regex));

        regex = "\\d{4}-\\d{2}-\\d{2}";
        Assert.assertFalse(StringUtil.isMatch(str, regex));
    }

    @Test
    public void testExtraGroupNames() {
        String regex = "(?<year>\\d{4})-(?<month>\\d{2})-(?<date>\\d{2})";
        Assert.assertEquals(StringUtil.extraGroupNames(regex).size(), 3);

        regex = "(\\d{4})-(\\d{2})-(\\d{2})";
        Assert.assertEquals(StringUtil.extraGroupNames(regex).size(), 0);

        regex = "(?<year>\\d{4})-(?<md>(?<month>\\d{2})-(?<date>\\d{2}))";
        Assert.assertEquals(StringUtil.extraGroupNames(regex).size(), 4);
    }

    @Test
    public void testBuildFromRegex() {
        String str = "1. 标题：[《title》](url)简评：comment";
        String regex = "《(?<title>\\S+)》]\\((?<url>\\S*)\\)简评：(?<comment>\\S+)";
        Record record = StringUtil.buildFromRegex(str, regex, Record.class);
        Assert.assertEquals(record.getTitle(), "title");
        Assert.assertEquals(record.getUrl(), "url");
        Assert.assertEquals(record.getComment(), "comment");
    }
}
