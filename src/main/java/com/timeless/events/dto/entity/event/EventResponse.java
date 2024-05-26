package com.timeless.events.dto.entity.event;

import com.timeless.events.model.Event;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

    private UUID id;
    private String title;
    private UUID eventCategoryId;
    private String banner;
    private UUID countryId;
    private Integer locationLat;
    private Integer locationLong;
    private String overview;
    private Date eventDatetime;

    public static EventResponse fromEntity(Event event) {
        return new EventResponse(
                event.getId(),
                event.getTitle(),
                event.getEventCaregoryId().getId(),
                event.getBanner(),
                event.getCountry().getId(),
                event.getLocationLat(),
                event.getLocationLong(),
                event.getOverview(),
                event.getEventDatetime()
        );
    }
}