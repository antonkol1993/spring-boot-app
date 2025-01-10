package com.koleso.spring.service.person_service;

import com.koleso.spring.dto.Person;
import com.koleso.spring.dto.Player;

import java.util.List;

public interface PersonService {

    List<Person> getPersons();

    List<Person> getPersons(int page, int pageSize);

    int getAllPersonsCount();

    Person getPersonById(Long id);

    void addPerson(Person person);

    void removePerson(Long id);

    void updatePerson(Person person);
}
