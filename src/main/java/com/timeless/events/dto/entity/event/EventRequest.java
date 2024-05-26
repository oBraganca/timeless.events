package com.timeless.events.dto.entity.event;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest{

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotNull(message = "Event Category is mandatory")
    private UUID eventCategoryId;

    @NotBlank(message = "Banner is mandatory")
    private String banner;

    @NotNull(message = "Country is mandatory")
    private UUID countryId;

    @NotNull(message = "Location latitude is mandatory")
    private Integer locationLat;

    @NotNull(message = "Location longitude is mandatory")
    private Integer locationLong;

    @NotBlank(message = "Overview is mandatory")
    private String overview;

    @NotNull(message = "Event datetime is mandatory")
    @Future(message = "Event datetime must be in the future")
    private Date eventDatetime;
}
