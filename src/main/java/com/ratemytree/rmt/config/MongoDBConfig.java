package com.ratemytree.rmt.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * David Schilling - davejs92@gmail.com
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.ratemytree.rmt")
@PropertySource(value = {"classpath:/application.properties", "classpath:/application-${environment:dev}.properties"})
public class MongoDBConfig {

    @Resource
    private Environment environment;

    @Bean
    public
    MongoClient mongo() throws Exception {
        return new MongoClient(environment.getRequiredProperty("mongodb.hostname"));
    }
    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongo(), environment.getRequiredProperty("mongodb.db"));
    }
}
