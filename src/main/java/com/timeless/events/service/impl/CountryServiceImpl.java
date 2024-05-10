package com.timeless.events.service.impl;

import com.timeless.events.controller.ICountryController;
import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.model.Country;
import com.timeless.events.repository.ICountryRepository;
import com.timeless.events.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CountryServiceImpl implements ICountryService {
    private final ICountryRepository iCountryRepository;

    @Autowired
    CountryServiceImpl(ICountryRepository iCountryRepository){
        this.iCountryRepository = iCountryRepository;
    }


    @Override
    public ResponseEntity<Void> createCountry(CountryRequest countryRequestDto) throws Exception {

        if(iCountryRepository.findByName(countryRequestDto.getName())){
            throw new Exception();
        }

        if(iCountryRepository.findByName(countryRequestDto.getPhoneCountryCode())){
            throw new Exception();
        }

        Country country;
        this.iCountryRepository.save(Country.Builder);
        return null;
    }

    @Override
    public ResponseEntity<List<CountryResponse>> getAllCountry() {
        return null;
    }

    @Override
    public ResponseEntity<CountryResponse> getCountryById(UUID id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateCountry(CountryRequest countryRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteCountry(UUID id) {
        return null;
    }
}
