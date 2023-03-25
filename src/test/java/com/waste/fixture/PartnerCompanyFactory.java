package com.waste.fixture;

import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.PartnerCompanyRequest;

import java.time.LocalDate;

public class PartnerCompanyFactory {
    private PartnerCompanyFactory() {}

    public static PartnerCompanyRequest createRequest(String name, String businessName) {
        return new PartnerCompanyRequest.Builder()
                .name(name)
                .location("location")
                .startedAt(LocalDate.of(2023, 1, 10))
                .businessName(businessName)
                .build();
    }
}
