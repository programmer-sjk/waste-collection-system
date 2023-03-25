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
}
