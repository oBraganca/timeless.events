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
    public void createCountry(CountryRequest countryRequestDto) throws Exception {

        Country country = iCountryRepository.findByName(countryRequestDto.getName());

        if(country != null){
            throw new Exception();
        }

        country = iCountryRepository.findByPhoneCountryCode(countryRequestDto.getPhoneCountryCode());
        if(country != null){
            throw new Exception();
        }

        this.iCountryRepository.save(Country.builder()
                .name(countryRequestDto.getName())
                .phoneCountryCode(countryRequestDto.getPhoneCountryCode())
        );
    }
    @Override
    public List<CountryResponse> getAllCountry(){
        return iCountryRepository.findAllCountryDTO();
    }

    @Override
    public CountryResponse getCountryById(UUID id) {
        Optional<Country> country = iCountryRepository.findById(id);
        return new CountryResponse(country.get().getId(), country.get().getName(), country.get().getPhoneCountryCode());
    }

    @Override
    public void updateCountry(CountryRequest countryRequestDto) throws Exception {
        Optional<Country> optionalCountry = iCountryRepository.findById(countryRequestDto.getId());

        if (!optionalCountry.isPresent()) {
            throw new Exception();
        }


        // Check if another country with the same name or phone country code already exists
        Country byName = iCountryRepository.findByNameAndIdNot(countryRequestDto.getName(), countryRequestDto.getId());
        if (byName != null) {
            throw new Exception();
        }

        Country byPhoneCountryCode = iCountryRepository.findByPhoneCountryCodeAndIdNot(countryRequestDto.getPhoneCountryCode(), countryRequestDto.getId());
        if (byPhoneCountryCode != null) {
            throw new Exception();
        }

        Country existingCountry = optionalCountry.get();

        existingCountry.setName(countryRequestDto.getName());
        existingCountry.setPhoneCountryCode(countryRequestDto.getPhoneCountryCode());

        iCountryRepository.save(existingCountry);
    }

    @Override
    public void deleteCountry(UUID id) throws Exception {
        Optional<Country> optionalCountry = iCountryRepository.findById(id);

        if (!optionalCountry.isPresent()) {
            throw new Exception();
        }

        iCountryRepository.deleteById(id);
    }
}
