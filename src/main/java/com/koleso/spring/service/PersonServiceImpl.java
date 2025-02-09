package com.koleso.spring.service;

import com.koleso.spring.dto.Person;
import com.koleso.spring.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> getPersons(int page, int pageSize) {
        Page<Person> persons = personRepository.findAll(PageRequest.of(page, pageSize));
        return persons.getContent();
    }

    @Override
    public int getAllPersonsCount() {
        return personRepository.findAll().size();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return person.orElseThrow();
    }

    @Override
    public List<Person> getPersonByName(String name) {
        return personRepository.findAllByFirstName(name);
    }

    @Override
    public void addPerson(Person Person) {
        personRepository.save(Person);
    }

    @Override
    public void removePerson(Long id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }

}
