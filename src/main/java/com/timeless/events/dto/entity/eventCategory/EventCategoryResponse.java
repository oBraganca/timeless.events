package com.timeless.events.dto.entity.eventCategory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class EventCategoryResponse {
    public EventCategoryResponse(UUID id, String title) {
        this.id = id;
        this.title = title;
    }

    private UUID id;

    private String title;
}
