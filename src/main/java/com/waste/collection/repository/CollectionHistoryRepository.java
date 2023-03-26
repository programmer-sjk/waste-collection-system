package com.waste.collection.repository;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionWithThumbnailResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CollectionHistoryRepository extends JpaRepository<CollectionHistory, Long> {
    @Query(value = """
        SELECT new com.waste.collection.dto.CollectionWithThumbnailResponse(
            p.name, h.collectedAt, t.filePath, p.location, p.businessName, h.amount, h.boxCount
        )
        FROM CollectionHistory h
        INNER JOIN PartnerCompany p ON p.id = h.partnerCompanyId
        LEFT JOIN CollectionThumbnail t ON t.historyId = h.id
        WHERE h.collectedAt BETWEEN :startedAt AND :endedAt
    """)
    List<CollectionWithThumbnailResponse> findAllByCollectedAtBetween(LocalDateTime startedAt, LocalDateTime endedAt);
}
