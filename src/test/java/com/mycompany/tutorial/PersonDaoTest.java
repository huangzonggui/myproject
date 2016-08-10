/*
 * Copyright 2016 Pivotal Software, Inc..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mycompany.tutorial;

import com.mycompany.tutorial.dao.PersonDao;
import org.appfuse.dao.BaseDaoTestCase;
import com.mycompany.tutorial.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import javax.transaction.Transactional;

import static org.junit.Assert.*;
import org.springframework.dao.DataAccessException;

/**
 *
 * @author hzg
 */
@Transactional
public class PersonDaoTest extends BaseDaoTestCase {

    @Autowired
    private PersonDao personDao;

    @Test
    public void testFindPersonByLastName() throws Exception {
        List<Person> people = personDao.findByLastName("Raible");
        log.debug(people.toString());
        assertTrue(people.size() > 0);
    }

    @Test
    public void testAddAndRemovePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Country");
        person.setLastName("Bry");

        person = personDao.save(person);
        flush();
//        List<Person> people = personDao.findByLastName("Bry");
//        log.debug(people.toString());

        person = personDao.get(person.getId());

        assertEquals("Country", person.getFirstName());
        assertNotNull(person.getId());

        log.debug("removing person...");

        personDao.remove(person.getId());
        flush();
        
        // should throw DataAccessException
//        personDao.get(person.getId());
    }
}
