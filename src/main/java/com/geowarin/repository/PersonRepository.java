package com.geowarin.repository;

import com.geowarin.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Date: 12/12/13
 * Time: 22:55
 *
 * @author Geoffroy Warin (http://geowarin.wordpress.com)
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

    List<Person> findByName(String lastname);

    List<Person> findByNameLike(String firstname);
}
