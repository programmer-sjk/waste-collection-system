package com.waste.partner_company.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PartnerCompany {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 32)
    private String name;
    @Column(length = 16)
    private String location;
    private LocalDate startedAt;
    @Column(length = 32, unique = true)
    private String businessName;

    protected PartnerCompany() {}

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
