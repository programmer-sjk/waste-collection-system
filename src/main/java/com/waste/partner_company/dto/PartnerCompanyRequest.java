package com.waste.partner_company.dto;

import com.waste.partner_company.domain.PartnerCompany;

import java.time.LocalDate;

public class PartnerCompanyRequest {
    private String name;
    private String location;
    private LocalDate startedAt;
    private String businessName;

    private PartnerCompanyRequest() {}

    public PartnerCompany toEntity() {
        return new PartnerCompany(name, location, startedAt, businessName);
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
