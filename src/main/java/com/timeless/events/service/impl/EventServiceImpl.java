package com.timeless.events.service.impl;

import com.timeless.events.dto.entity.event.EventRequest;
import com.timeless.events.dto.entity.event.EventResponse;
import com.timeless.events.handler.exceptions.NotFoundException;
import com.timeless.events.model.Country;
import com.timeless.events.model.Event;
import com.timeless.events.model.EventCategory;
import com.timeless.events.repository.IEventRepository;
import com.timeless.events.service.ICountryService;
import com.timeless.events.service.IEventCategoryService;
import com.timeless.events.service.IEventService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class EventServiceImpl implements IEventService {

    private final IEventRepository iEventRepository;
    private final IEventCategoryService iEventCategoryService;
    private final ICountryService iCountryService;

    EventServiceImpl(IEventRepository iEventRepository, IEventCategoryService iEventCategoryService, ICountryService iCountryService){
        this.iEventRepository = iEventRepository;
        this.iEventCategoryService = iEventCategoryService;
        this.iCountryService = iCountryService;

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
        return iEventRepository.findAllEventDTO();
    }

    @Override
    public EventResponse getEventById(UUID id) throws Exception {

        Optional<Event> optionalEvent = iEventRepository.findById(id);

        if(!optionalEvent.isPresent()){
            throw new NotFoundException("id");
        }

        return EventResponse.fromEntity(optionalEvent.get());
    }

    @Override
    public void updateEvent(UUID id, EventRequest eventRequest) throws Exception {

        Optional<Event> optionalEvent = iEventRepository.findById(id);

        if(!optionalEvent.isPresent()){
            throw new NotFoundException("id");
        }

        EventCategory eventCategory = iEventCategoryService.getEventCategoryEntityById(eventRequest.getEventCategoryId());

        Country country = iCountryService.getCountryEntityById(eventRequest.getCountryId());

        Event event = optionalEvent.get();



        event.setTitle(eventRequest.getTitle());
        event.setEventCategoryId(eventCategory);
        event.setBanner(eventRequest.getBanner());
        event.setCountryId(country);
        event.setLocationLat(eventRequest.getLocationLat());
        event.setLocationLong(eventRequest.getLocationLong());
        event.setOverview(eventRequest.getOverview());
        event.setEventDatetime(eventRequest.getEventDatetime());

    }

    @Override
    public void deleteEvent(UUID id) throws Exception {

    }
}
