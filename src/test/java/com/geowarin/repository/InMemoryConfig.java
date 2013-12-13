package com.geowarin.repository;

import com.foursquare.fongo.Fongo;
import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
* Date: 12/12/13
* Time: 23:15
*
* @author Geoffroy Warin (http://geowarin.wordpress.com)
*/
@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = {"com.geowarin.rest", "com.geowarin.service"})
public class InMemoryConfig extends AbstractMongoConfiguration {

    @Override
    protected String getDatabaseName() {
        return "demo-test";
    }

    @Override
    @Bean
    public Mongo mongo() {
        return new Fongo("mongo-test").getMongo();
    }
}
