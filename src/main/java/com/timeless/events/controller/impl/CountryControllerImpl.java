package com.timeless.events.controller.impl;

import com.timeless.events.controller.ICountryController;
import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(value = "v1/")
public class CountryControllerImpl implements ICountryController {
    @Override
    public ResponseEntity<Void> createCountry(CountryRequest countryRequestDto) {
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
