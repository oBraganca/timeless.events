package com.timeless.events.controller;

import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Validated
public interface ITierController {
    ResponseEntity<Void> createTier(@Valid @RequestBody TierRequest tierRequest) throws Exception;
    ResponseEntity<List<TierResponse>> getAllTiers();
    ResponseEntity<TierResponse> getTierById(@NotNull @PathVariable UUID id) throws Exception;
    ResponseEntity<Void> updateTier(@NotNull @PathVariable UUID id, @Valid @RequestBody TierRequest tierRequest) throws Exception;
    ResponseEntity<Void> deleteTier(@NotNull @PathVariable UUID id) throws Exception;

}
