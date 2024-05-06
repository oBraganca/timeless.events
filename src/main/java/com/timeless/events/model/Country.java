package com.timeless.events.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = false, name="name")
    private String name;

    @Column(nullable = false, unique = false, name="phone_country_code")
    private Integer phoneCountryCode;
}
