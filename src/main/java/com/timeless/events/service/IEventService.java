package com.timeless.events.service;

import com.timeless.events.dto.entity.event.EventRequest;
import com.timeless.events.dto.entity.event.EventResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IEventService {
    void createEvent(@Valid @RequestBody EventRequest eventRequest) throws Exception;
    List<EventResponse> getAllEvents();
    EventResponse getEventById(@NotNull @PathVariable UUID id) throws Exception;
    void updateEvent(UUID id, EventRequest eventRequest) throws Exception;
    void deleteEvent(UUID id) throws Exception;

}
