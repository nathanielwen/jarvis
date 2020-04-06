package com.wonqee.jarvis.controller;

import com.wonqee.jarvis.domain.Block;
import com.wonqee.jarvis.domain.Record;
import com.wonqee.jarvis.service.Parser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Wing on 20/4/6.
 */
@RestController
public class ManualController {

    @GetMapping("/test")
    public List<Record> test() {

        Parser parser = new Parser();
        List<Block> blocks = parser.parse("/Users/Wing/Desktop/test.md");

        return blocks.stream()
                .map(Block::getRecords)
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
