package com.waste.collection.dto;

import com.waste.collection.domain.CollectionHistory;

import java.time.LocalDateTime;

public class CollectionHistoryResponse {
    private Long id;
    private Long partnerCompanyId;
    private int amount;
    private int boxCount;
    private int thumbnailCount;
    private String note;
    private LocalDateTime collectedAt;

    private CollectionHistoryResponse() {}

    public CollectionHistoryResponse(CollectionHistory history) {
        this.id = history.getId();
        this.partnerCompanyId = history.getPartnerCompanyId();
        this.amount = history.getAmount();
        this.boxCount = history.getBoxCount();
        this.thumbnailCount = history.getThumbnailCount();
        this.note = history.getNote();
        this.collectedAt = history.getCollectedAt();
    }

    public Long getId() {
        return id;
    }

    public Long getPartnerCompanyId() {
        return partnerCompanyId;
    }

    public int getAmount() {
        return amount;
    }

    public int getBoxCount() {
        return boxCount;
    }

    public int getThumbnailCount() {
        return thumbnailCount;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCollectedAt() {
        return collectedAt;
    }
}
