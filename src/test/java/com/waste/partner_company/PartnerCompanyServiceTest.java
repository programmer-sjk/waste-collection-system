package com.waste.partner_company;

import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.CollectionAmountResponse;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class PartnerCompanyServiceTest {
    @Autowired
    private PartnerCompanyService partnerCompanyService;
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;

    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @BeforeEach
    void setUp() {
        this.partnerCompanyRepository.deleteAll();
        this.collectionHistoryRepository.deleteAll();
    }

    @DisplayName("업장에 대한 수거량 데이터를 조회할 수 있다.")
    @Test
    void find() {
        // given
        PartnerCompany partnerCompany = partnerCompanyRepository.save(PartnerCompanyFactory.create("버거킹"));
        CollectionHistory history = collectionHistoryRepository.save(
                CollectionHistoryFactory.createWithPartnerCompany(partnerCompany.getId(), LocalDateTime.now())
        );

        // when
        List<CollectionAmountResponse> results = partnerCompanyService.findAllWithAmount(partnerCompany.getId());

        // then
        CollectionAmountResponse result = results.get(0);
        assertThat(result.getName()).isEqualTo("버거킹");
        assertThat(result.getAmount()).isEqualTo(history.getAmount());
        assertThat(result.getBoxCount()).isEqualTo(history.getBoxCount());
    }

    @DisplayName("업장을 추가할 수 있다.")
    @Test
    void register() {
        // given
        PartnerCompanyRequest request = PartnerCompanyFactory.createRequest("맘스터치", "김맘스");

        // when
        partnerCompanyService.register(request);

        // then
        List<PartnerCompany> results = partnerCompanyRepository.findAll();
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("맘스터치");
    }

    @DisplayName("동일 사업자명을 가진 업장을 추가하면 예외가 발생한다.")
    @Test
    void registerDuplicateBusinessNameException() {
        // given
        PartnerCompanyRequest request = PartnerCompanyFactory.createRequest("터치터치", "김맘스");
        partnerCompanyService.register(request);

        // when & then
        assertThatThrownBy(() -> partnerCompanyService.register(request))
                .isInstanceOf(DataIntegrityViolationException.class);
    }
}
