package com.timeless.events.service.impl;

import com.timeless.events.dto.entity.event.EventRequest;
import com.timeless.events.dto.entity.event.EventResponse;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.dto.entity.tier.TierRequest;
import com.timeless.events.dto.entity.tier.TierResponse;
import com.timeless.events.handler.exceptions.NotFoundException;
import com.timeless.events.model.Country;
import com.timeless.events.model.Event;
import com.timeless.events.model.EventCategory;
import com.timeless.events.model.Tier;
import com.timeless.events.repository.IEventCategoryRepository;
import com.timeless.events.repository.IEventRepository;
import com.timeless.events.repository.ITierRepository;
import com.timeless.events.service.ICountryService;
import com.timeless.events.service.IEventCategoryService;
import com.timeless.events.service.IEventService;
import com.timeless.events.service.ITierService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventServiceImpl implements IEventService {

    private final IEventRepository iEventRepository;
    private final IEventCategoryService iEventCategoryService;
    private final ITierService iTierService;
    private final ICountryService iCountryService;

    EventServiceImpl(IEventRepository iEventRepository, IEventCategoryService iEventCategoryService, ITierService iTierService, ICountryService iCountryService){
        this.iEventRepository = iEventRepository;
        this.iEventCategoryService = iEventCategoryService;
        this.iCountryService = iCountryService;
        this.iTierService = iTierService;

    }

    @Override
    public void createEvent(EventRequest eventRequest) throws Exception {

        EventCategory eventCategory = iEventCategoryService.getEventCategoryEntityById(eventRequest.getEventCategoryId());

        Country country = iCountryService.getCountryEntityById(eventRequest.getCountryId());


        iEventRepository.save(Event.builder()
                .title(eventRequest.getTitle())
                .eventCategoryId(eventCategory)
                .banner(eventRequest.getBanner())
                .countryId(country)
                .locationLat(eventRequest.getLocationLat())
                .locationLong(eventRequest.getLocationLong())
                .overview(eventRequest.getOverview())
                .eventDatetime(eventRequest.getEventDatetime())

                .build());


    }

    @Override
    public List<EventResponse> getAllEvents() {
        return ;
    }

    @Override
    public EventResponse getEventById(UUID id) throws Exception {
        return null;
    }

    @Override
    public void updateEvent(UUID id, EventRequest eventRequest) throws Exception {

    }

    @Override
    public void deleteEvent(UUID id) throws Exception {

    }
}
