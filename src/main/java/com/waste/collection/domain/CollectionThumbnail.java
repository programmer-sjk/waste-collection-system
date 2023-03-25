package com.waste.collection.domain;

import com.waste.common.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CollectionThumbnail extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath;
    @Column(length = 16)
    private String extension;
    private Long historyId;

    protected CollectionThumbnail() {}

    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getExtension() {
        return extension;
    }

    public Long getHistoryId() {
        return historyId;
    }
}
