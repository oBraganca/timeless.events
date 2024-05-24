package com.timeless.events.dto.entity.eventCategory;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class EventCategoryRequest {

    private UUID id;

    @NotBlank(message = "title is mandatory")
    private String title;
}
