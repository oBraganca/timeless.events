package com.timeless.events.dto.entity.country;

import com.timeless.events.dto.entity.event.EventResponse;
import com.timeless.events.model.Country;
import com.timeless.events.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryResponse {

    @NotNull
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private Integer phoneCountryCode;


    public static CountryResponse fromEntity(Country country) {
        return new CountryResponse(
                country.getId(),
                country.getName(),
                country.getPhoneCountryCode()
        );
    }

}
