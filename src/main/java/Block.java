import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
public class Block {
    private List<Record> records;

    @Getter
    @Setter
    private String date;

    private List<String> content = new ArrayList<String>();

    public void addContent(String line) {
        content.add(line);
    }
}
