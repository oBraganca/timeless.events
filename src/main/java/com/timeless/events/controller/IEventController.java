package com.timeless.events.controller;

import com.timeless.events.dto.entity.event.EventRequest;
import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Validated
public interface IEventController {

    ResponseEntity<Void> createEvent(@Valid @RequestBody EventRequest eventRequest) throws Exception;
    ResponseEntity<List<EventRequest>> getAllEvent();
    ResponseEntity<EventRequest> getEventById(@NotNull @PathVariable UUID id) throws Exception;
    ResponseEntity<Void> updateEvent(@NotNull @PathVariable UUID id, @Valid @RequestBody EventRequest eventRequest) throws Exception;
    ResponseEntity<Void> deleteEvent(@NotNull @PathVariable UUID id) throws Exception;


}
