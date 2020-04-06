import com.google.common.io.Files;
import domain.Block;
import util.StringUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
public class Parser {

    private static final String BLOCK_START = "-----";

    private static final String DATE_REGEX = "\\d{4}/\\d{2}/\\d{2}";

    public List<Block> parse(String path) {

        List<Block> blocks = new ArrayList<>();

        Block block = new Block();
        try {
            File file = new File(path);
            Charset charset = Charset.defaultCharset();
            List<String> lines = Files.readLines(file, charset);
            for (String line: lines) {
                if (StringUtil.equals(BLOCK_START, line)) {
                    blocks.add(block);
                    block = new Block();
                } else if (StringUtil.isMatch(line, DATE_REGEX)) {
                    block.setDate(line);
                } else if (StringUtil.isBlank(line)) {
                    continue;
                } else {
                    block.addContent(line);
                }
            }
            blocks.remove(0);
        } catch (IOException e) {
            blocks = null;
        }

        return blocks;
    }
}
