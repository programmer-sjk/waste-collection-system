package com.waste.collection;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionHistoryResponse;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.fixture.CollectionHistoryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectionServiceTest {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @BeforeEach
    void setUp() {
        this.collectionHistoryRepository.deleteAll();
    }

    @DisplayName("수거 이력정보를 조회할 수 있다.")
    @Test
    void findAll() {
        // given
        CollectionHistory history = collectionHistoryRepository.save(CollectionHistoryFactory.create());

        // when
        List<CollectionHistoryResponse> results = collectionService.findAllHistory(PageRequest.of(0, 1));

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getId()).isEqualTo(history.getId());
    }

    @DisplayName("수거 이력정보 조회기능은 페이지네이션 된다.")
    @Test
    void pagination() {
        // given
        int totalCount = 6;
        for (int i = 0; i < totalCount - 1; i++) {
            collectionHistoryRepository.save(CollectionHistoryFactory.create());
        }
        CollectionHistory history = collectionHistoryRepository.save(CollectionHistoryFactory.create());

        // when
        List<CollectionHistoryResponse> response = collectionService.findAllHistory(PageRequest.of(1, 5));

        // then
        assertThat(response).hasSize(1);
        assertThat(response.get(0).getId()).isEqualTo(history.getId());
    }
}
