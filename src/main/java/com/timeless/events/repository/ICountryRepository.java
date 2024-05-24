package com.timeless.events.repository;

import com.timeless.events.dto.entity.country.CountryResponse;
import com.timeless.events.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ICountryRepository extends JpaRepository<Country, UUID> {
    Optional<Country> findById(UUID id);

    Country findByNameAndIdNot (String name, UUID id);
    Country findByPhoneCountryCodeAndIdNot(Integer name, UUID id);
    @Query("SELECT new com.timeless.events.dto.entity.country.CountryResponse(c.id, c.name, c.phoneCountryCode) FROM Country c")
    List<CountryResponse> findAllCountryDTO();

    public <S extends Country.CountryBuilder> S save(S entity);
    Country findByName(String name);
    Country findByPhoneCountryCode(Integer phoneCountryCode);
}
