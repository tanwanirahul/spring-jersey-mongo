package com.geowarin.rest;

import com.geowarin.model.Person;
import com.geowarin.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Date: 13/12/13
 * Time: 13:44
 *
 * @author Geoffroy Warin (http://geowarin.wordpress.com)
 */
@Path("persons")
@Component
public class PersonResource {

    @Autowired
    private PersonRepository repository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Person> getPersons() {
        return repository.findAll();
    }
}
