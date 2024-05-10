package com.timeless.events.repository;

import com.timeless.events.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICountryRepository extends JpaRepository<Country, UUID> {
    Optional<Country> findById(UUID id);
    public <S extends Country.CountryBuilder> S save(S entity);
    Country findByName(String name);
    Country findByPhoneCountryCode(Integer phoneCountryCode);
}
