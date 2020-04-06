package com.wonqee.jarvis.controller;

import com.wonqee.jarvis.domain.Record;
import com.wonqee.jarvis.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Wing on 20/4/6.
 */
@RestController
@RequestMapping("records")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping("/all")
    public List<Record> findAll() {
        return recordService.findAll();
    }

    @GetMapping("/delete")
    public String delete(String id) {
        recordService.deleteById(id);
        return "OK";
    }

    /*@GetMapping("/deleteAll")
    public String deleteAll() {
        recordService.deleteAll();
        return "OK";
    }

    @GetMapping("/importFromFile")
    public String importFromFile() {
        Parser parser = new Parser();
        List<Block> blocks = parser.parse("/Users/Wing/Desktop/test.md");

        List<Record> records = blocks.stream()
                .map(Block::getRecords)
                .flatMap(Collection::stream)
                .collect(toList());

        records.forEach(record -> recordService.save(record));

        return "OK";
    }*/
}
