package com.mycompany.service;

import com.mycompany.model.Person;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

/**
 * Created by hzg on 2016/8/12.
 */
//To expose your PersonManager (and its implementation) as a SOAP service, add a @WebService annotation to the interface.
//@WebService
@Path("/people")
public interface PersonManager extends GenericManager<Person,Long> {

    @GET
    @Path("{lastname}")
    List<Person> findByLastName(String lastName);

    @GET
    List<Person> getPeople();
}
