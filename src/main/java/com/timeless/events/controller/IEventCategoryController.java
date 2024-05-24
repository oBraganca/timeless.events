package com.timeless.events.controller;

import com.timeless.events.dto.entity.eventCategory.EventCategoryRequest;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

public interface IEventCategoryController {
    ResponseEntity<Void> createEventCategory(@Valid @RequestBody EventCategoryRequest eventCategoryRequest) throws Exception;
    ResponseEntity<List<EventCategoryResponse>> getAllEventCategory();
    ResponseEntity<EventCategoryResponse> getEventCategoryById( @NotNull @PathVariable("id") UUID id) throws Exception;
    ResponseEntity<Void> updateEventCategory(@NotNull @PathVariable("id") UUID id, @Valid @RequestBody EventCategoryRequest eventCategoryRequest) throws Exception;
    ResponseEntity<Void> deleteEventCategory(@NotNull @PathVariable("id") UUID id) throws Exception;

}
