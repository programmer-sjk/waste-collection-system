package com.waste.partner_company.dto;

import com.waste.partner_company.domain.PartnerCompany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class PartnerCompanyRequest {
    @NotBlank
    @Size(max = 32)
    private String name;
    @NotBlank
    @Size(max = 16)
    private String location;
    @NotNull
    private LocalDate startedAt;
    @NotBlank
    @Size(max = 32)
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


    public static final class Builder {
        private String name;
        private String location;
        private LocalDate startedAt;
        private String businessName;

        public static Builder builder() {
            return new Builder();
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder location(String location) {
            this.location = location;
            return this;
        }

        public Builder startedAt(LocalDate startedAt) {
            this.startedAt = startedAt;
            return this;
        }

        public Builder businessName(String businessName) {
            this.businessName = businessName;
            return this;
        }

        public PartnerCompanyRequest build() {
            PartnerCompanyRequest partnerCompanyRequest = new PartnerCompanyRequest();
            partnerCompanyRequest.startedAt = this.startedAt;
            partnerCompanyRequest.location = this.location;
            partnerCompanyRequest.name = this.name;
            partnerCompanyRequest.businessName = this.businessName;
            return partnerCompanyRequest;
        }
    }
}
