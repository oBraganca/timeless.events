package com.timeless.events.dto.entity.tier;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.UUID;

@Data
public class TierRequest {

    private UUID id;

    @NotBlank(message = "title is mandatory")
    private String title;


}
