package com.waste.collection;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionHistoryResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collection")
public class CollectionController {
    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping("/history")
    public List<CollectionHistoryResponse> findAll(Pageable pageable) {
        return collectionService.findAllHistory(pageable);
    }
}
