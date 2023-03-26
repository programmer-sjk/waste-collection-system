package com.waste.collection;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionHistoryResponse;
import com.waste.collection.dto.CollectionWithThumbnailResponse;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.collection.repository.CollectionThumbnailRepository;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.PartnerCompanyRepository;
import com.waste.partner_company.domain.PartnerCompany;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CollectionServiceTest {
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;

    @BeforeEach
    void setUp() {
        this.collectionHistoryRepository.deleteAll();
        this.partnerCompanyRepository.deleteAll();
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

    @DisplayName("수거 시간에 해당하는 이력과 수거 사진 정보를 조회할 수 있다.")
    @Test
    void findAllByCollectedAt() {
        // given
        PartnerCompany company = partnerCompanyRepository.save(PartnerCompanyFactory.create("맘스터치"));
        Long companyId = company.getId();

        LocalDateTime today = LocalDateTime.now();
        LocalDateTime yesterday = today.minusDays(1);

        collectionHistoryRepository.save(CollectionHistoryFactory.createWithPartnerCompany(companyId, today));
        collectionHistoryRepository.save(CollectionHistoryFactory.createWithPartnerCompany(companyId, yesterday));

        // when
        List<CollectionWithThumbnailResponse> results = collectionService.findAllByCollectedAt(LocalDate.now());

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getCompanyName()).isEqualTo("맘스터치");
    }
}
