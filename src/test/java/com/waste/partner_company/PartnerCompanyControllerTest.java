package com.waste.partner_company;

import com.waste.AcceptanceTest;
import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.CollectionAmountResponse;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartnerCompanyControllerTest extends AcceptanceTest {
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;

    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @DisplayName("업장에 대한 수거량 데이터를 조회할 수 있다.")
    @Test
    void find() {
        // given
        PartnerCompany partnerCompany = partnerCompanyRepository.save(PartnerCompanyFactory.create("버거킹"));
        CollectionHistory history = collectionHistoryRepository.save(
                CollectionHistoryFactory.createWithPartnerCompany(partnerCompany.getId(), LocalDateTime.now())
        );

        // when
        List<CollectionAmountResponse> results = findAllWithAmount(partnerCompany.getId());

        // then
        CollectionAmountResponse result = results.get(0);
        assertThat(result.getName()).isEqualTo("버거킹");
        assertThat(result.getAmount()).isEqualTo(history.getAmount());
        assertThat(result.getBoxCount()).isEqualTo(history.getBoxCount());
    }

    @DisplayName("업장을 추가할 수 있다.")
    @Test
    void register() {
        // when
        register(PartnerCompanyFactory.createRequest("맘스", "맘스터치"));

        // then
        List<PartnerCompany> results = partnerCompanyRepository.findAll();
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getName()).isEqualTo("맘스");
    }

    private List<CollectionAmountResponse> findAllWithAmount(Long id) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(String.format("/partner-company/%d", id))
                .then().log().all()
                .extract()
                .jsonPath()
                .getList("data", CollectionAmountResponse.class);
    }

    public void register(PartnerCompanyRequest request) {
        RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when().post("/partner-company")
                .then().log().all()
                .extract();
    }
}
