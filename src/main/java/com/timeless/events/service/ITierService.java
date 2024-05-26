package com.timeless.events.service;

import com.timeless.events.dto.entity.eventCategory.EventCategoryRequest;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface ITierService {
    void createTier(TierRequest tierRequest) throws Exception;
    List<TierResponse> getAllTiers();
    TierResponse getTierById(UUID id) throws Exception;
    void updateTier(UUID id, TierRequest tierRequest) throws Exception;
    void deleteTier(UUID id) throws Exception;
}
