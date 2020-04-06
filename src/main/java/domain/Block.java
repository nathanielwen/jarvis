package domain;

import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
public class Block {

    private static final String REGEX = "《(?<title>\\S+)》]\\((?<url>\\S*)\\)简评：(?<comment>\\S+)";

    private List<Record> records = new ArrayList<>();

    @Setter
    private String date;

    private List<String> content = new ArrayList<>();

    private StringBuilder builder = new StringBuilder();

    public void addContent(String line) {
        if (StringUtils.startsWith(line, "》]")) {
            builder.append(line);
        } else if (StringUtils.startsWith(line, "简评：")) {
            builder.append(line);
            content.add(builder.toString());

            Record record = StringUtil.buildFromRegex(builder.toString(), REGEX, Record.class);
            records.add(record);
        } else {
            builder = new StringBuilder(line);

        }
    }
}
