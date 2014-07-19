package com.ratemytree.rmt.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * David Schilling - davejs92@gmail.com
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.ratemytree.rmt")
public class MongoDBConfig {

    public @Bean
    MongoClient mongo() throws Exception {
        return new MongoClient("localhost");
    }

    public @Bean MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), "mydb");
    }
}
