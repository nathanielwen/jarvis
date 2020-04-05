import lombok.Setter;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
public class Block {

    private List<Record> records;

    @Setter
    private String date;

    private List<String> content = new ArrayList<String>();

    public void addContent(String line) {
        content.add(line);
    }

    public List<String> format() {

        List<String> formattedContent = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (String line : content) {
            if (StringUtils.startsWith(line, "》]")) {
                builder.append(line);
                continue;
            } else if (StringUtils.startsWith(line, "简评：")) {
                builder.append(line);
                formattedContent.add(builder.toString());
                continue;
            } else {
                builder = new StringBuilder(line);
            }
        }
        return formattedContent;
    }
}
