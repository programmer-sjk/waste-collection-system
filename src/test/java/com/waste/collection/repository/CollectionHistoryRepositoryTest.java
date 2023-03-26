package com.waste.collection.repository;

import com.waste.collection.dto.CollectionWithThumbnailResponse;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.PartnerCompanyRepository;
import com.waste.partner_company.domain.PartnerCompany;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class CollectionHistoryRepositoryTest {
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;
    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;
    @Autowired
    private CollectionThumbnailRepository collectionThumbnailRepository;

    @DisplayName("수거시간에 해당하는 수거이력과 사진 정보를 조회할 수 있다.")
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
        List<CollectionWithThumbnailResponse> results = collectionHistoryRepository.findAllByCollectedAtBetween(
                LocalDate.now().atTime(LocalTime.MIN),
                LocalDate.now().atTime(LocalTime.MAX)
        );

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getCompanyName()).isEqualTo("맘스터치");
    }
}
