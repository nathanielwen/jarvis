package com.wonqee.jarvis.domain;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Wing on 20/4/4.
 */
@Data
@ToString
@Document(collection = "record")
public class Record implements Serializable {

    private static final long serialVersionUID = 5094995541812833015L;

    @Id
    private String id;

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

    /**
     * 日期
     */
    private Date date;
}
