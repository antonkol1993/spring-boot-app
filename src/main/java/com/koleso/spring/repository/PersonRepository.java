package com.koleso.spring.repository;

import com.koleso.spring.dto.Game;
import com.koleso.spring.dto.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findAllByName(String name);
}
