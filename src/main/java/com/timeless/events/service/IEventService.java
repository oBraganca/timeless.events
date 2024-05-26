package com.timeless.events.service;

import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    void createTier(@Valid @RequestBody TierRequest tierRequest) throws Exception;
    List<TierResponse> getAllTiers();
    TierResponse getTierById(@NotNull @PathVariable UUID id) throws Exception;
    void updateTier(UUID id, TierRequest tierRequest) throws Exception;
    void deleteTier(UUID id) throws Exception;

}
