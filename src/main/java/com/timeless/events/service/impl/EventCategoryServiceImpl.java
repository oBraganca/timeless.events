package com.timeless.events.service.impl;

import com.timeless.events.dto.entity.eventCategory.EventCategoryRequest;
import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.handler.exceptions.AlreadyExistsException;
import com.timeless.events.handler.exceptions.NotFoundException;
import com.timeless.events.model.Country;
import com.timeless.events.model.EventCategory;
import com.timeless.events.repository.IEventCategoryRepository;
import com.timeless.events.service.IEventCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EventCategoryServiceImpl implements IEventCategoryService {
    private final IEventCategoryRepository iEventCategoryRepository;

    @Autowired
    EventCategoryServiceImpl(IEventCategoryRepository iEventCategoryRepository){
        this.iEventCategoryRepository = iEventCategoryRepository;
    }


    @Override
    public void createEventCategory(EventCategoryRequest eventCategoryRequest) throws Exception {

        EventCategory eventCategory = iEventCategoryRepository.findByTitle(eventCategoryRequest.getTitle());
        if(eventCategory != null){
            throw new AlreadyExistsException("Title");
        }


        eventCategory = EventCategory.builder()
                .title(eventCategoryRequest.getTitle()).build();

        iEventCategoryRepository.save(eventCategory);
    }

    @Override
    public List<EventCategoryResponse> getAllEventCategories() {
        return iEventCategoryRepository.findAllEventCategoryDTO();
    }

    @Override
    public EventCategoryResponse getEventCategoryById(UUID id) throws Exception {

        Optional<EventCategory> optionalEventCategory = iEventCategoryRepository.findById(id);

        if(!optionalEventCategory.isPresent()){
            throw new NotFoundException("Id");
        }

        return new EventCategoryResponse(optionalEventCategory.get().getId(), optionalEventCategory.get().getTitle());
    }

    @Override
    public void updateEventCategory(UUID id, EventCategoryRequest eventCategoryRequest) throws Exception {
        Optional<EventCategory> optionalEventCategory = iEventCategoryRepository.findById(id);

        if(!optionalEventCategory.isPresent()){
            throw new NotFoundException("Id");
        }

        EventCategory eventCategory = iEventCategoryRepository.findByTileAndIdNot(eventCategoryRequest.getTitle(), id);
        if(eventCategory != null){
            throw new AlreadyExistsException("Title");
        }

        eventCategory = optionalEventCategory.get();

        eventCategory.setTitle(eventCategoryRequest.getTitle());

        iEventCategoryRepository.save(eventCategory);
    }

    @Override
    public void deleteEventCategory(UUID id) throws Exception {

    }
}
