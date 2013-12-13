package com.geowarin.rest;

import com.geowarin.model.Person;
import com.geowarin.repository.InMemoryConfig;
import com.geowarin.repository.PersonRepository;
import com.lordofthejars.nosqlunit.annotation.UsingDataSet;
import com.lordofthejars.nosqlunit.core.LoadStrategyEnum;
import com.lordofthejars.nosqlunit.mongodb.MongoDbRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.lordofthejars.nosqlunit.mongodb.MongoDbRule.MongoDbRuleBuilder.newMongoDbRule;
import static org.fest.assertions.Assertions.assertThat;

/**
 * Date: 13/12/13
 * Time: 13:46
 *
 * @author Geoffroy Warin (http://geowarin.wordpress.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InMemoryConfig.class)
public class PersonResourceTest {

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");

    // nosql-unit requirement
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private PersonResource personResource;

    @Test
    @UsingDataSet(locations = {"/persons.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void getAllPersons(){
        Iterable<Person> persons = personResource.getPersons();
        assertThat(persons).hasSize(1);
    }
}
