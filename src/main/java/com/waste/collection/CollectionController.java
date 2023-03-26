package com.waste.collection;

import com.waste.collection.dto.CollectionHistoryResponse;
import com.waste.collection.dto.CollectionWithThumbnailResponse;
import com.waste.common.ResponseMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping()
    public ResponseMessage<List<CollectionWithThumbnailResponse>> findAllByCollectedAt(
            @RequestParam LocalDate collectedAt
    ) {
        return ResponseMessage.ok(collectionService.findAllByCollectedAt(collectedAt));
    }
}
