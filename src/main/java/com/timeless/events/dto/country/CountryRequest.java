package com.timeless.events.dto.country;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class CountryRequest {
    @NotNull
    private String name;
    @NotNull
    private Integer phoneCountryCode;
}
