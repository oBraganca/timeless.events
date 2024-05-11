package com.timeless.events.service;

import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.repository.ICountryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICountryService {
    void createCountry(CountryRequest countryRequestDto) throws Exception;
    List<CountryResponse> getAllCountry();
    CountryResponse getCountryById(UUID id);
    void updateCountry(CountryRequest countryRequestDto);
    void deleteCountry(UUID id);
}
