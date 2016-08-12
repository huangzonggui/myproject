package com.mycompany.service.impl;

import com.mycompany.dao.GenericDao;
import com.mycompany.dao.PersonDao;
import com.mycompany.model.Person;
import com.mycompany.service.PersonManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by hzg on 2016/8/12.
 */
@Service("personManager")
//@WebService(serviceName = "PersonService", endpointInterface = "com.mycompany.service.PersonManager")
public class PersonManagerImpl extends GenericManagerImpl<Person, Long> implements PersonManager {
    PersonDao personDao;

    public PersonManagerImpl(){}
    //    If you registered the personDao using the @Repository("personDao") annotation instead of src/main/webapp/WEB-INF/applicationContext.xml file you will need to auto-wire the PersonDao variable in the PersonManagerImpl class:
    @Autowired

    public PersonManagerImpl(PersonDao personDao) {
        super(personDao);
        this.personDao = personDao;
    }

    public List<Person> findByLastName(String lastName) {
        return personDao.findByLastName(lastName);
    }

    public List<Person> getPeople() {
        return personDao.getAll();
    }
}
