package com.waste.partner_company;

import com.waste.AcceptanceTest;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import io.restassured.RestAssured;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PartnerCompanyControllerTest extends AcceptanceTest {
    @Autowired
    private PartnerCompanyRepository partnerCompanyRepository;

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
