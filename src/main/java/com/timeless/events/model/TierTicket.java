package com.timeless.events.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tier_ticket")
public class TierTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "price")
    private Float price;

    @ManyToOne
    @Column(nullable = false, name = "event_id")
    private String eventId;

    @ManyToOne
    @Column(nullable = false, name = "tier_id")
    private Tier tierId;
}
