package com.wonqee.jarvis.service;

import com.wonqee.jarvis.domain.Block;
import com.wonqee.jarvis.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by Wing on 20/4/6.
 */
public class RecordServiceTest {

    @Autowired
    private RecordService recordService;

    @Test
    public void deleteAll() {
        recordService.deleteAll();
    }

    @Test
    public void importFromFile() {
        Parser parser = new Parser();
        List<Block> blocks = parser.parse("/Users/Wing/Desktop/test.md");

        List<Record> records = blocks.stream()
                .map(Block::getRecords)
                .flatMap(Collection::stream)
                .collect(toList());

        records.forEach(record -> recordService.save(record));
    }
}
