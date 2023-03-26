package com.waste.collection.dto;

import com.waste.collection.domain.CollectionHistory;

import java.time.LocalDateTime;

public class CollectionWithThumbnailResponse {
    private String companyName;
    private LocalDateTime collectedAt;
    private ThumbnailResponse response;

    private CollectionWithThumbnailResponse() {}

    public CollectionWithThumbnailResponse(
            String companyName,
            LocalDateTime collectedAt,
            String filePath,
            String location,
            String businessName,
            int amount,
            int boxCount
    ) {
        this.companyName = companyName;
        this.collectedAt = collectedAt;
        this.response = new ThumbnailResponse(filePath, location, businessName, amount, boxCount);
    }

    public String getCompanyName() {
        return companyName;
    }

    public LocalDateTime getCollectedAt() {
        return collectedAt;
    }

    public ThumbnailResponse getResponse() {
        return response;
    }
}
