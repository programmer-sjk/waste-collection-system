package com.waste.collection.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class CollectionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    public static final class Builder {
        private Long id;
        private Long partnerCompanyId;
        private int amount;
        private int boxCount;
        private int thumbnailCount;
        private String note;
        private LocalDateTime collectedAt;

        public Builder() {}

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder partnerCompanyId(Long partnerCompanyId) {
            this.partnerCompanyId = partnerCompanyId;
            return this;
        }

        public Builder amount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder boxCount(int boxCount) {
            this.boxCount = boxCount;
            return this;
        }

        public Builder thumbnailCount(int thumbnailCount) {
            this.thumbnailCount = thumbnailCount;
            return this;
        }

        public Builder note(String note) {
            this.note = note;
            return this;
        }

        public Builder collectedAt(LocalDateTime collectedAt) {
            this.collectedAt = collectedAt;
            return this;
        }

        public CollectionHistory build() {
            CollectionHistory collectionHistory = new CollectionHistory();
            collectionHistory.partnerCompanyId = this.partnerCompanyId;
            collectionHistory.boxCount = this.boxCount;
            collectionHistory.id = this.id;
            collectionHistory.thumbnailCount = this.thumbnailCount;
            collectionHistory.collectedAt = this.collectedAt;
            collectionHistory.amount = this.amount;
            collectionHistory.note = this.note;
            return collectionHistory;
        }
    }
}
