package com.wonqee.jarvis.service;

import com.wonqee.jarvis.domain.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Wing on 20/4/6.
 */
@Component
public class RecordService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Record> findAll() {
        Query query = new Query();
        List<Record> records = mongoTemplate.find(query, Record.class);
        return records;
    }

    public void save(Record record) {
        mongoTemplate.save(record);
    }

    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, Record.class);
    }

    public void deleteAll() {
        Query query = new Query();
        mongoTemplate.remove(query, Record.class);
    }
}
