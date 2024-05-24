package com.timeless.events.controller.impl;

import com.timeless.events.controller.ICountryController;
import com.timeless.events.dto.entity.country.CountryRequest;
import com.timeless.events.dto.entity.country.CountryResponse;
import com.timeless.events.service.ICountryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Void> createCountry(@Valid @RequestBody CountryRequest countryRequestDto) throws Exception{
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
    public ResponseEntity<CountryResponse> getCountryById(@NotNull @PathVariable("id") UUID id) throws Exception {
        return new ResponseEntity<>(iCountryService.getCountryById(id), HttpStatus.OK);
    }


    @Override
    @PutMapping("/countries/{id}")
    public ResponseEntity<Void> updateCountry(@NotNull @PathVariable("id") UUID id , @Valid @RequestBody CountryRequest countryRequestDto) throws Exception {
        iCountryService.updateCountry(id, countryRequestDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping("countries/{id}")
    public ResponseEntity<Void> deleteCountry(@NotNull @PathVariable("id") UUID id) throws Exception {
        iCountryService.deleteCountry(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
