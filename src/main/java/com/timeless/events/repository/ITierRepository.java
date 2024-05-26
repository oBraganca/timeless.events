package com.timeless.events.repository;

import com.timeless.events.dto.entity.tier.TierResponse;
import com.timeless.events.model.Tier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ITierRepository extends JpaRepository<Tier, UUID> {
    @Override
    Optional<Tier> findById(UUID id);

    Tier findByTitle(String title);
    Tier findByTitleAndIdNot(String title, UUID id);


    @Query("SELECT new com.timeless.events.dto.entity.tier.TierResponse(t.id, t.title) FROM Tier t")
    List<TierResponse> findAllTierDTO();

}
