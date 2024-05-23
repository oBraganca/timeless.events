package com.timeless.events.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "tier_tickets")
public class TierTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, name = "price")
    private Float price;

    @ManyToOne
    private Event eventId;

    @ManyToOne
    private Tier tierId;
}
