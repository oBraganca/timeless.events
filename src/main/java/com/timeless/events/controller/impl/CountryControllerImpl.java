package com.timeless.events.controller.impl;

import com.timeless.events.controller.ICountryController;
import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpClient;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(value = "v1/")
public class CountryControllerImpl implements ICountryController {
    private final ICountryService iCountryService;

    @Autowired
    CountryControllerImpl(ICountryService iCountryService){
        this.iCountryService = iCountryService;
    }

    @Override
    public ResponseEntity<Void> createCountry(@RequestBody CountryRequest countryRequestDto) throws Exception{
        iCountryService.createCountry(countryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CountryResponse>> getAllCountry() {
        return new ResponseEntity<>(iCountryService.getAllCountry(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CountryResponse> getCountryById(UUID id) {
        return new ResponseEntity<>(iCountryService.getCountryById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateCountry(CountryRequest countryRequestDto) throws Exception {
        iCountryService.updateCountry(countryRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> deleteCountry(UUID id) throws Exception {
        iCountryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
