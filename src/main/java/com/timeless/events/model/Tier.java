package com.timeless.events.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name="tiers")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tier {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, name = "title")
    private String title;
}
