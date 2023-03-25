package com.waste.partner_company.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class PartnerCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 32)
    private String name;
    @Column(length = 16)
    private String location;
    private LocalDate startedAt;
    @Column(length = 32, unique = true)
    private String businessName;

    protected PartnerCompany() {}

    public PartnerCompany(String name, String location, LocalDate startedAt, String businessName) {
        this.name = name;
        this.location = location;
        this.startedAt = startedAt;
        this.businessName = businessName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getStartedAt() {
        return startedAt;
    }

    public String getBusinessName() {
        return businessName;
    }
}
