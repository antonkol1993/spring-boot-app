package com.koleso.spring.repository;

import com.koleso.spring.dto.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findAllByName(String name);
}
