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
    public ResponseMessage<List<CollectionHistoryResponse>> findAll(Pageable pageable) {
        List<CollectionHistoryResponse> responses = collectionService.findAllHistory(pageable);
        return ResponseMessage.ok(responses);
    }

    @GetMapping()
    public ResponseMessage<List<CollectionWithThumbnailResponse>> findAllByCollectedAt(
            @RequestParam LocalDate collectedAt
    ) {
        List<CollectionWithThumbnailResponse> responses = collectionService.findAllByCollectedAt(collectedAt);
        return ResponseMessage.ok(responses);
    }
}
