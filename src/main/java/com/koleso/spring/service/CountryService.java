package com.koleso.spring.service;

import com.koleso.spring.objects.Country;

import java.util.List;

public interface CountryService {

    List<Country> getCountries(int page, int pageSize);

    List<Country> getAllCountries();

    int getAllCountriesCount();

    Country getCountryById(Long id);

    List<Country> getCountriesByName(String name);

    void addCountry(Country Country);

    void removeCountry(Long id);

    void updateCountry(Country country);
}
