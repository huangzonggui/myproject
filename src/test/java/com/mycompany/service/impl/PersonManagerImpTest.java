package com.mycompany.service.impl;

import com.mycompany.dao.PersonDao;
import com.mycompany.model.Person;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertSame;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.BDDMockito.willReturn;
import static org.mockito.Mockito.verify;

/**
 * Created by hzg on 2016/8/12.
 */
public class PersonManagerImpTest extends BaseManagerMockTestCase {

    @InjectMocks
    private PersonManagerImpl manager;

    @Mock
    private PersonDao dao;

    @Test
    public void testGetPerson() {
        log.debug("testing get...");
//        given
        final Long id = 7L;
        final Person person = new Person();
        given(dao.get(id)).willReturn(person);
//        when
        Person result = manager.get(id);
        //then
        assertSame(person, result);
    }

    @Test
    public void testGetPersons() {
        log.debug("testing getAll....");
        //given
        final List persons = new ArrayList();
        given(dao.getAll()).willReturn(persons);
        //when
        List result = manager.getAll();
        //then
        assertSame(persons, result);
    }

    @Test
    public void testSavePerson() {
        log.debug("testing save...");
        //given
        final Person person = new Person();
        //enter all required fields

        given(dao.save(person)).willReturn(person);
        //when
        manager.save(person);
        //then
        verify(dao).save(person);
    }

    @Test
    public void testRemovePerson() {
        log.debug("testing remove...");
        //given
        final Long id = -11L;
        willDoNothing().given(dao).remove(id);
        //when
        manager.remove(id);
        //then
        verify(dao).remove(id);
    }

}
