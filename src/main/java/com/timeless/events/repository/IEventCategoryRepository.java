package com.timeless.events.repository;

import com.timeless.events.dto.entity.eventCategory.EventCategoryResponse;
import com.timeless.events.model.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface IEventCategoryRepository extends JpaRepository<EventCategory, UUID> {
    @Override
    Optional<EventCategory> findById(UUID id);

    EventCategory findByTitle(String title);
    EventCategory findByTileAndIdNot(String title, UUID id);

    @Query("SELECT new com.timeless.events.dto.entity.eventCategory.EventCategoryResponse(e.id, e.title) FROM EventCategory e")
    List<EventCategoryResponse> findAllEventCategoryDTO();
}

