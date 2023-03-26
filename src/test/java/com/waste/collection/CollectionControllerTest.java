package com.waste.collection;

import com.waste.AcceptanceTest;
import com.waste.collection.domain.CollectionHistory;
import com.waste.collection.dto.CollectionHistoryResponse;
import com.waste.collection.repository.CollectionHistoryRepository;
import com.waste.fixture.CollectionHistoryFactory;
import com.waste.fixture.PartnerCompanyFactory;
import com.waste.partner_company.PartnerCompanyRepository;
import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CollectionControllerTest extends AcceptanceTest {
    @Autowired
    private CollectionHistoryRepository collectionHistoryRepository;

    @DisplayName("수거 이력정보를 조회할 수 있다.")
    @Test
    void findAll() {
        // given
        int page = 0, size = 5;
        CollectionHistory history1 = collectionHistoryRepository.save(CollectionHistoryFactory.create());
        CollectionHistory history2 = collectionHistoryRepository.save(CollectionHistoryFactory.create());
        CollectionHistory history3 = collectionHistoryRepository.save(CollectionHistoryFactory.create());

        // when
        List<CollectionHistoryResponse> results = findAll(page, size);

        // then
        assertThat(results).hasSize(3);
        List<Long> ids = results.stream().map(CollectionHistoryResponse::getId).toList();
        assertThat(ids).contains(history1.getId(), history2.getId(), history3.getId());
    }

    @DisplayName("수거 이력정보는 페이지네이션 된다.")
    @Test
    void pagination() {
        // given
        int page = 0, size = 5, totalCount = 6;
        for (int i = 0; i < totalCount - 1; i++) {
            collectionHistoryRepository.save(CollectionHistoryFactory.create());
        }
        CollectionHistory expect = collectionHistoryRepository.save(CollectionHistoryFactory.create());
        findAll(page, size);

        // when
        List<CollectionHistoryResponse> results = findAll(page + 1, size);

        // then
        assertThat(results).hasSize(1);
        assertThat(results.get(0).getId()).isEqualTo(expect.getId());
    }

    private List<CollectionHistoryResponse> findAll(int page, int size) {
        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .when().get(String.format("/collection/history?page=%d&size=%d", page, size))
                .then().log().all()
                .extract()
                .jsonPath()
                .getList(".", CollectionHistoryResponse.class);
    }
}
