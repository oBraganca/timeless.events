package com.timeless.events.repository;

import com.timeless.events.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ICountryRepository extends JpaRepository<Country, UUID> {
    Country findByName(String name);
    Country findByPhoneCountryCode(Integer phoneCountryCode);
}
