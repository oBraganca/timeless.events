package com.timeless.events.dto.entity.tier;

import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.model.EventCategory;
import com.timeless.events.model.Tier;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TierResponse {
    private UUID id;

    private String title;

    public static TierResponse fromEntity(Tier tier) {
        return new TierResponse(
                tier.getId(),
                tier.getTitle()
        );
    }

}
