package com.timeless.events.dto.entity.eventCategory;

import com.timeless.events.dto.entity.country.CountryResponse;
import com.timeless.events.model.Country;
import com.timeless.events.model.EventCategory;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventCategoryResponse {

    private UUID id;

    private String title;

    public static EventCategoryResponse fromEntity(EventCategory eventCategory) {
        return new EventCategoryResponse(
                eventCategory.getId(),
                eventCategory.getTitle()
        );
    }
}
