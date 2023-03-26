package com.waste.partner_company;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.CollectionAmountResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PartnerCompanyRepositoryTest {
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;
    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @DisplayName("특정 업장의 수거 이력 정보를 구할 수 있다.")
    @Test
    void findById() {
        // given
        PartnerCompany partnerCompany = partnerCompanyRepository.save(PartnerCompanyFactory.create("버거킹"));
        collectionHistoryRepository.save(CollectionHistoryFactory.createWithPartnerCompany(
                partnerCompany.getId(), LocalDateTime.now()));
        collectionHistoryRepository.save(CollectionHistoryFactory.createWithPartnerCompany(
                partnerCompany.getId(), LocalDateTime.now()));
        collectionHistoryRepository.save(CollectionHistoryFactory.createWithPartnerCompany(
                partnerCompany.getId(), LocalDateTime.now()));

        // when
        List<CollectionAmountResponse> results =
                partnerCompanyRepository.findAllWithHistoryAmount(partnerCompany.getId());

        // then
        assertThat(results).hasSize(3);
        assertThat(results.get(0).getName()).isEqualTo("버거킹");
    }
}
