package com.timeless.events.dto.country;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Data
public class CountryRequest {
    @NotNull
    private UUID     id;
    @NotNull
    private String name;
    @NotNull
    private Integer phoneCountryCode;
}
