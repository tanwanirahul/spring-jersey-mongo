package com.geowarin.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Date: 12/12/13
 * Time: 22:32
 *
 * @author Geoffroy Warin (http://geowarin.wordpress.com)
 */
@Configuration
@EnableMongoRepositories
class ApplicationConfig extends AbstractMongoConfiguration {

    @Override
    public Mongo mongo() throws Exception {
        return new Mongo();
    }

    @Override
    protected String getDatabaseName() {
        return "test";
    }
}