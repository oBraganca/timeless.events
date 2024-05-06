package com.timeless.events.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "title")
    private String title;

    @ManyToOne
    @Column(nullable = false, name = "event_category_id")
    private EventCategory eventCaregoryId;

    @Column(nullable = false, name = "banner")
    private String banner;

    @ManyToOne
    @Column(nullable = false, name = "country_id")
    private Country country;

    @Column(nullable = false, name="localtion_lat")
    private Integer locationLat;

    @Column(nullable = false, name="localtion_long")
    private Integer locationLong;

    @Column(nullable = false, name="overview")
    private String overview;

    @Column(nullable = false, name="event_datetime")
    private Date eventDatetime;


}
