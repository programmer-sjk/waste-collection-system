package com.waste.collection;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionHistoryResponse;
import com.waste.collection.repository.CollectionHistoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional(readOnly = true)
@Service
public class CollectionService {
    private final CollectionHistoryRepository collectionHistoryRepository;

    public CollectionService(CollectionHistoryRepository collectionHistoryRepository) {
        this.collectionHistoryRepository = collectionHistoryRepository;
    }

    public List<CollectionHistoryResponse> findAllHistory(Pageable pageable) {
        Page<CollectionHistory> histories = collectionHistoryRepository.findAll(pageable);
        return histories.stream()
                .map(CollectionHistoryResponse::new)
                .collect(Collectors.toList());
    }
}
