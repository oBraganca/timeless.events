package com.timeless.events.controller.impl;

import com.timeless.events.controller.IEventController;
import com.timeless.events.dto.entity.event.EventRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class EventControllerImpl implements IEventController {
    @Override
    public ResponseEntity<Void> createEvent(EventRequest eventRequest) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<EventRequest>> getAllEvent() {
        return null;
    }

    @Override
    public ResponseEntity<EventRequest> getEventById(UUID id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> updateEvent(UUID id, EventRequest eventRequest) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteEvent(UUID id) throws Exception {
        return null;
    }
}
