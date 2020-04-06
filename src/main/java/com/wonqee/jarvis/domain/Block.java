package com.wonqee.jarvis.domain;

import com.wonqee.jarvis.util.DateUtil;
import com.wonqee.jarvis.util.StringUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
public class Block {

    private static final String REGEX = "标题：\\[《?(?<title>.+?)》?\\]\\((?<url>.*)\\)简评：(?<comment>.+)";

    @Getter
    private List<Record> records = new ArrayList<>();

    @Setter
    private String date;

    private List<String> content = new ArrayList<>();

    private StringBuilder builder = new StringBuilder();

    public void addContent(String line) {
        if (StringUtil.startsWith(line, "》]")
                || StringUtil.startsWith(line, ")")) {
            builder.append(line);
        } else if (StringUtil.startsWith(line, "简评：")
                || StringUtil.startsWith(line, ")简评：")) {
            builder.append(line);
            content.add(builder.toString());

            Record record = StringUtil.buildFromRegex(builder.toString(), REGEX, Record.class);
            if (record == null) {
                throw new RuntimeException(this.content.toString());
            }
            record.setDate(DateUtil.valueOf(date, DateUtil.COMMON_FORMAT));
            records.add(record);
        } else {
            builder = new StringBuilder(line);
        }
    }
}
