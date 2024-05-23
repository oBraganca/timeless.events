package com.timeless.events.service.impl;

import com.timeless.events.dto.country.CountryRequest;
import com.timeless.events.dto.country.CountryResponse;
import com.timeless.events.handler.exceptions.AlreadyExistsException;
import com.timeless.events.handler.exceptions.NotFoundException;
import com.timeless.events.model.Country;
import com.timeless.events.repository.ICountryRepository;
import com.timeless.events.service.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
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

        System.out.println(country);
        if(country != null){
            throw new AlreadyExistsException("Name");
        }

        country = iCountryRepository.findByPhoneCountryCode(countryRequestDto.getPhoneCountryCode());
        if(country != null){
            throw new AlreadyExistsException("Phone Country Code");
        }

        country = Country.builder()
                .name(countryRequestDto.getName())
                .phoneCountryCode(countryRequestDto.getPhoneCountryCode()).build();

        iCountryRepository.save(country);

    }
    @Override
    public List<CountryResponse> getAllCountry(){
        return iCountryRepository.findAllCountryDTO();
    }

    @Override
    public CountryResponse getCountryById(UUID id) throws Exception {
        Optional<Country> optionalCountry = iCountryRepository.findById(id);
        if(!optionalCountry.isPresent()){
            throw new NotFoundException("Id");
        }
        return new CountryResponse(optionalCountry.get().getId(), optionalCountry.get().getName(), optionalCountry.get().getPhoneCountryCode());
    }

    @Override
    public void updateCountry(UUID id, CountryRequest countryRequestDto) throws Exception {
        Optional<Country> optionalCountry = iCountryRepository.findById(id);

        if (!optionalCountry.isPresent()) {
            throw new NotFoundException("Id");
        }


        // Check if another country with the same name or phone country code already exists
        Country byName = iCountryRepository.findByNameAndIdNot(countryRequestDto.getName(), id);
        if (byName != null) {
            throw new AlreadyExistsException("Name");
        }

        Country byPhoneCountryCode = iCountryRepository.findByPhoneCountryCodeAndIdNot(countryRequestDto.getPhoneCountryCode(), id);
        if (byPhoneCountryCode != null) {
            throw new AlreadyExistsException("Phone Country Code");
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
            throw new NotFoundException("Id");
        }

        iCountryRepository.deleteById(id);
    }
}
