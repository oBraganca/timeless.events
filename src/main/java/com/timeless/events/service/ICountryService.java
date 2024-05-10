package com.timeless.events.service;

import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICountryService {
    ResponseEntity<Void> createCountry(CountryRequest countryRequestDto) throws Exception;
    ResponseEntity<List<CountryResponse>> getAllCountry();
    ResponseEntity<CountryResponse> getCountryById(UUID id);
    ResponseEntity<Void> updateCountry(CountryRequest countryRequestDto);
    ResponseEntity<Void> deleteCountry(UUID id);
}
