package com.waste.collection.domain;

import com.waste.common.BaseEntity;
import jakarta.persistence.*;

@Entity
public class CollectionThumbnail extends BaseEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String filePath;
    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private ThumbnailExtension extension;
    private Long historyId;

    protected CollectionThumbnail() {}

    public Long getId() {
        return id;
    }

    public String getFilePath() {
        return filePath;
    }

    public ThumbnailExtension getExtension() {
        return extension;
    }

    public Long getHistoryId() {
        return historyId;
    }
}
