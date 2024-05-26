package com.timeless.events.repository;

import com.timeless.events.dto.entity.event.EventResponse;
import com.timeless.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IEventRepository extends JpaRepository<Event, UUID> {

    @Override
    Optional<Event> findById(UUID id);

    @Query("SELECT new com.timeless.events.dto.EventResponseDTO(e.id, e.title, e.eventCategoryId.id, e.banner, e.country.id, e.locationLat, e.locationLong, e.overview, e.eventDatetime) FROM Event e")
    List<EventResponse> findAllEventDTO();
}
