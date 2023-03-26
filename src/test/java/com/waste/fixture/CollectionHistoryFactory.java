package com.waste.fixture;

import com.waste.collection.domain.CollectionHistory;
import com.waste.partner_company.dto.PartnerCompanyRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CollectionHistoryFactory {
    private CollectionHistoryFactory() {}

    public static CollectionHistory create() {
        return new CollectionHistory.Builder()
                .partnerCompanyId(1L)
                .amount(10)
                .boxCount(1)
                .thumbnailCount(5)
                .note("note")
                .collectedAt(LocalDateTime.now())
                .build();
    }

    public static CollectionHistory createWithPartnerCompany(Long partnerCompanyId, LocalDateTime collectedAt) {
        return new CollectionHistory.Builder()
                .partnerCompanyId(partnerCompanyId)
                .amount(10)
                .boxCount(1)
                .thumbnailCount(5)
                .note("note")
                .collectedAt(collectedAt)
                .build();
    }
}
