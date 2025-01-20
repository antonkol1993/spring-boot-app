package com.koleso.spring.service;

import com.koleso.spring.dto.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries(int page, int pageSize);

    int getAllCountriesCount();

    Country getCountryById(Long id);
    List<Country> getCountryByName(String name);

    void addCountry(Country Country);

    void removeCountry(Long id);

    void updateCountry(Country country);
}
