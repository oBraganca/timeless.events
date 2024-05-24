package com.timeless.events.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="event_categorys")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EventCategory {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, name = "title")
    private String title;
}
