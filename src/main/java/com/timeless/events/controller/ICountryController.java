package com.timeless.events.controller;

import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.model.Country;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Validated
public interface ICountryController {
    ResponseEntity<Void> createCountry(CountryRequest countryRequestDto) throws Exception;
    ResponseEntity<List<CountryResponse>> getAllCountry();
    ResponseEntity<CountryResponse> getCountryById(UUID id);
    ResponseEntity<Void> updateCountry(CountryRequest countryRequestDto) throws Exception;
    ResponseEntity<Void> deleteCountry(UUID id) throws Exception;

}
