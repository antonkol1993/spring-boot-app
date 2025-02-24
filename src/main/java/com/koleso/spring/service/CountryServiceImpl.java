package com.koleso.spring.service;

import com.koleso.spring.objects.Country;
import com.koleso.spring.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;


    @Override
    public List<Country> getCountries(int page, int pageSize) {
        Page<Country> countries = countryRepository.findAll(PageRequest.of(page, pageSize));
        return countries.getContent();
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public int getAllCountriesCount() {
        return countryRepository.findAll().size();
    }

    @Override
    public Country getCountryById(Long id) {
        Optional<Country> country = countryRepository.findById(id);
        return country.orElseThrow();
    }

    @Override
    public List<Country> getCountriesByName(String name) {
        return countryRepository.findAllByName(name);
    }

    @Override
    public void addCountry(Country Country) {
        countryRepository.save(Country);
    }

    @Override
    public void removeCountry(Long id) {
        countryRepository.deleteById(id);
    }

    @Override
    public void updateCountry(Country country) {
        countryRepository.save(country);
    }
}
