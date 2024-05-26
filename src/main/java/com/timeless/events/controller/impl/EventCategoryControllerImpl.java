package com.timeless.events.controller.impl;

import com.timeless.events.controller.IEventCategoryController;
import com.timeless.events.dto.entity.eventCategory.EventCategoryRequest;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.service.IEventCategoryService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@Validated
@RestController
@RequestMapping("v1/")
public class EventCategoryControllerImpl implements IEventCategoryController {

    private final IEventCategoryService iEventCategoryService;

    @Autowired
    EventCategoryControllerImpl(IEventCategoryService iEventCategoryService){
        this.iEventCategoryService = iEventCategoryService;
    }


    @Override
    @PostMapping(value = "event-categories")
    public ResponseEntity<Void> createEventCategory(@Valid @RequestBody EventCategoryRequest eventCategoryRequest) throws Exception {
        iEventCategoryService.createEventCategory(eventCategoryRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "event-categories")
    public ResponseEntity<List<EventCategoryResponse>> getAllEventCategory() {
        return new ResponseEntity<>(iEventCategoryService.getAllEventCategories(), HttpStatus.CREATED);
    }

    @Override
    @GetMapping(value = "event-categories/{id}")
    public ResponseEntity<EventCategoryResponse> getEventCategoryById(@NotNull @PathVariable("id") UUID id) throws Exception {
        return new ResponseEntity<>(iEventCategoryService.getEventCategoryById(id), HttpStatus.OK);
    }

    @Override
    @PutMapping(value = "event-categories/{id}")
    public ResponseEntity<Void> updateEventCategory(@NotNull @PathVariable("id") UUID id, @Valid @RequestBody  EventCategoryRequest eventCategoryRequest) throws Exception {
        iEventCategoryService.updateEventCategory(id, eventCategoryRequest);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @DeleteMapping(value = "event-categories/{id}")
    public ResponseEntity<Void> deleteEventCategory(@NotNull @PathVariable("id") UUID id) throws Exception {
        iEventCategoryService.deleteEventCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
