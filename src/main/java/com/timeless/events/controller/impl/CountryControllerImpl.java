package com.timeless.events.controller.impl;

import com.timeless.events.controller.ICountryController;
import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/countries")
    public ResponseEntity<Void> createCountry(@RequestBody CountryRequest countryRequestDto) throws Exception{
        iCountryService.createCountry(countryRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping("/countries")
    public ResponseEntity<List<CountryResponse>> getAllCountry() {
        return new ResponseEntity<>(iCountryService.getAllCountry(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/countries/{id}")
    public ResponseEntity<CountryResponse> getCountryById(UUID id) throws Exception {
        return new ResponseEntity<>(iCountryService.getCountryById(id), HttpStatus.OK);
    }


    @Override
    @PutMapping("/countries/{id}")
    public ResponseEntity<Void> updateCountry(UUID id ,CountryRequest countryRequestDto) throws Exception {
        iCountryService.updateCountry(id, countryRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("countries/{id}")
    @Override
    public ResponseEntity<Void> deleteCountry(UUID id) throws Exception {
        iCountryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
