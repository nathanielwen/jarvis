package domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
@Getter
@Setter
public class Record {
    /**
     * 标题
     */
    private String title;

    /**
     * 链接
     */
    private String url;

    /**
     * 简评
     */
    private String comment;

    /**
     * 推荐的书
     */
    private String book;

    /**
     * 标签
     */
    private List<String> tags;

    private String date;
}
