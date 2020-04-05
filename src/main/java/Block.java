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

    private StringBuilder builder = new StringBuilder();

    public void addContent(String line) {
        if (StringUtils.startsWith(line, "》]")) {
            builder.append(line);
        } else if (StringUtils.startsWith(line, "简评：")) {
            builder.append(line);
            content.add(builder.toString());
        } else {
            builder = new StringBuilder(line);
        }
    }
}
