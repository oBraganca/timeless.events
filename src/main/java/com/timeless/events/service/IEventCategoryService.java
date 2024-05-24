package com.timeless.events.service;

import com.timeless.events.dto.entity.country.CountryRequest;
import com.timeless.events.dto.entity.country.CountryResponse;
import com.timeless.events.dto.entity.eventCategory.EventCategoryRequest;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IEventCategoryService {
    void createEventCategory(EventCategoryRequest eventCategoryRequest) throws Exception;
    List<EventCategoryResponse> getAllEventCategories();
    EventCategoryResponse getEventCategoryById(UUID id) throws Exception;
    void updateEventCategory(UUID id, EventCategoryRequest eventCategoryRequest) throws Exception;
    void deleteEventCategory(UUID id) throws Exception;
}
