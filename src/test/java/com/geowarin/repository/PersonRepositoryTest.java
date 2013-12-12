package com.geowarin.repository;

import com.geowarin.model.Person;
import com.lordofthejars.nosqlunit.annotation.ShouldMatchDataSet;
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
 * Date: 12/12/13
 * Time: 22:56
 *
 * @author Geoffroy Warin (http://geowarin.wordpress.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InMemoryConfig.class)
public class PersonRepositoryTest {

    @Rule
    public MongoDbRule mongoDbRule = newMongoDbRule().defaultSpringMongoDb("demo-test");

    // nosql-unit requirement
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private PersonRepository personRepository;

    /**
     * Expected results are in "one-person.json" file
     */
    @Test
    @ShouldMatchDataSet(location = "/persons.json")
    public void testInsert() {
        Person person = new Person("Jean", 42);
        personRepository.save(person);
    }

    @Test
    @UsingDataSet(locations = {"/persons.json"}, loadStrategy = LoadStrategyEnum.CLEAN_INSERT)
    public void testCountAllPersons(){
        long total = personRepository.count();
        assertThat(total).isEqualTo(1);
    }

}
