package com.timeless.events.service;

import com.timeless.events.dto.entity.country.CountryRequest;
import com.timeless.events.dto.entity.country.CountryResponse;
import com.timeless.events.model.Country;
import com.timeless.events.model.EventCategory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ICountryService {
    void createCountry(CountryRequest countryRequestDto) throws Exception;
    List<CountryResponse> getAllCountry();
    CountryResponse getCountryById(UUID id) throws Exception;
    Country getCountryEntityById(UUID id) throws Exception;
    void updateCountry(UUID id, CountryRequest countryRequestDto) throws Exception;
    void deleteCountry(UUID id) throws Exception;
}
