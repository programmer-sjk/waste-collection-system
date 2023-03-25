package com.waste.collection.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CollectionHistory {
    @Id
    @GeneratedValue
    private Long id;

    private Long partnerCompanyId;
    private int amount;
    private int boxCount;
    private int thumbnailCount;
    private String note;
    private LocalDateTime collectedAt;

    protected CollectionHistory() {}

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
