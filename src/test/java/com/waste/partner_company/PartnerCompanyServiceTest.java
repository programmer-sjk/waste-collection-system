package com.waste.partner_company;

import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class PartnerCompanyServiceTest {
    @Autowired
    private PartnerCompanyService partnerCompanyService;
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;

    @BeforeEach
    void setUp() {
        this.partnerCompanyRepository.deleteAll();
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
