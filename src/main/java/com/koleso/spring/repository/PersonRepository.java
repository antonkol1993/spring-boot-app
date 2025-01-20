package com.koleso.spring.repository;

import com.koleso.spring.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByFirstName(String firstName);
    List<Person> findAllByLastName(String lastName);
}
