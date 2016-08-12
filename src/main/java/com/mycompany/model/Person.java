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
package com.mycompany.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author hzg
 */
@XmlRootElement
@Entity
@Table(name = "person")
public class Person extends BaseObject {

    private Long id;
    private String firstName;
    private String lastName;

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //     @ id 注释表示主键  @GeneratedValue 注释指定显示主键的生成策略。 
    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    //    你也可以把JPA注释字段代替 getter 。 然而,你应该知道,如果你添加字段级注释, 方法级注释将被忽略
    @Column(name = "first_name", length = 50)
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Person{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
