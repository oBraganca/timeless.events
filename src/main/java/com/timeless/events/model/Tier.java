package com.timeless.events.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name="tier")
public class Tier {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, name = "title")
    private String title;
}
