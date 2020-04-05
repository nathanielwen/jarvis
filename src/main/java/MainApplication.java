import java.util.List;

/**
 * Created by Wing on 20/4/5.
 */
public class MainApplication {
    public static void main(String[] args) {
        Parser parser = new Parser();
        List<Block> blocks = parser.parse("/Users/Wing/Desktop/test.md");
        return;
    }
}
