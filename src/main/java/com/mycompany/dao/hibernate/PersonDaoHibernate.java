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
package com.mycompany.dao.hibernate;

import com.mycompany.dao.PersonDao;
import com.mycompany.model.Person;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author hzg
 */
@Repository("PersonDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao {
    public PersonDaoHibernate(){
        super(Person.class);
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
    }
}
