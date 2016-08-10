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
package com.mycompany.tutorial.dao.hibernate;

import java.util.List;
 
import org.appfuse.dao.hibernate.GenericDaoHibernate;
import com.mycompany.tutorial.model.Person;
import com.mycompany.tutorial.dao.PersonDao;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author hzg
 */
@Repository("PersonDao")
public class PersonDaoHibernate extends GenericDaoHibernate<Person, Long> implements PersonDao{
    public PersonDaoHibernate(){
        super(Person.class);
    }

    @Override
    public List<Person> findByLastName(String lastName) {
        return getSession().createCriteria(Person.class).add(Restrictions.eq("lastName", lastName)).list();
    }
}
