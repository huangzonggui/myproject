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
package com.mycompany.dao;

import com.mycompany.model.Person;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author hzg
 */
@TransactionConfiguration(defaultRollback = false)
//设置默认回滚为false，这样数据就会保存到数据库，可以看到有数据添加到数据库，否则测试可以通过，但是看不到
public class PersonDaoTest extends BaseDaoTestCase{

    @Autowired
    private PersonDao personDao;

    @Test
    public void testFindPersonByLastName() throws Exception {
        List<Person> people = personDao.findByLastName("Raible");
        log.debug(people.toString());
        assertTrue(people.size() > 0);
    }

    @Test(expected = DataAccessException.class)
    //预期抛出DataAccessException这个异常，不抛出测试失败
//    @Test
    public void testAddAndRemovePerson() throws Exception {
        Person person = new Person();
        person.setFirstName("Country");
        person.setLastName("Bry");

        person = personDao.save(person);
        flush();
//        log.debug(people.toString());

//        for (int i=0;i<3;i++){
//            List<Person> people = personDao.findByLastName("Bry");
//
//            assertEquals("Country", person.getFirstName());
//            assertNotNull(person.getId());
//
//            log.debug("removing person...");
//
//            personDao.remove(person.getId());
//            flush();
//
//        }
        person = personDao.get(person.getId());

        assertEquals("Country", person.getFirstName());
        assertNotNull(person.getId());

        log.debug("removing person...");

        personDao.remove(person.getId());
        flush();

        // should throw DataAccessException
        personDao.get(person.getId());
    }
}
