import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by Wing on 20/4/5.
 */
public class MainApplication {
    public static void main(String[] args) {
        Parser parser = new Parser();
        List<Block> blocks = parser.parse("/Users/Wing/Desktop/test.md");
        List<String> con = blocks.stream()
                .map(Block::format)
                .flatMap(Collection::stream)
                .collect(toList());
        return;
    }
}
