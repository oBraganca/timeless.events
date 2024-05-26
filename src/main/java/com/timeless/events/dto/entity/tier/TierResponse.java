package com.timeless.events.dto.entity.tier;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public class TierResponse {
    public TierResponse(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    private UUID id;

    private String title;
}
