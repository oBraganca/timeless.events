package com.timeless.events.dto.country;

import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

public class CountryResponse {
    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String phoneCountryCode;

}
