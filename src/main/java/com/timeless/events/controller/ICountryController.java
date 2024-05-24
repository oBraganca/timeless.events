package com.timeless.events.controller;

import com.timeless.events.dto.entity.country.CountryRequest;
import com.timeless.events.dto.entity.country.CountryResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Validated
public interface ICountryController {
    ResponseEntity<Void> createCountry(@Valid @RequestBody CountryRequest countryRequestDto) throws Exception;
    ResponseEntity<List<CountryResponse>> getAllCountry();
    ResponseEntity<CountryResponse> getCountryById( @NotNull @PathVariable("id")UUID id) throws Exception;
    ResponseEntity<Void> updateCountry(@NotNull @PathVariable("id") UUID id, @Valid @RequestBody CountryRequest countryRequestDto) throws Exception;
    ResponseEntity<Void> deleteCountry(@NotNull @PathVariable("id") UUID id) throws Exception;

}
