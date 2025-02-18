package com.koleso.spring.repository;

import com.koleso.spring.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByFirstName(String firstName);
    Optional<Person> findPersonByUsername(String username);
}
