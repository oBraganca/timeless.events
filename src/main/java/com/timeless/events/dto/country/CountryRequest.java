package com.timeless.events.dto.country;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Data
public class CountryRequest {

    private UUID id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotNull(message = "Phone Country Code is mandatory")
    private Integer phoneCountryCode;
}
