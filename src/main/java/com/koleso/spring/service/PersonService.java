package com.koleso.spring.service;

import com.koleso.spring.dto.Person;

import java.util.List;

public interface PersonService {


    List<Person> getPersons(int page, int pageSize);

    int getAllPersonsCount();

    Person getPersonById(Long id);

    Person getPersonByUsername(String name);

    void addPerson(Person person);

    void removePerson(Long id);

    void updatePerson(Person person);
}
