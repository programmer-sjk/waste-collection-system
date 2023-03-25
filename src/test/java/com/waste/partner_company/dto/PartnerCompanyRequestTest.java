package com.waste.partner_company.dto;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class PartnerCompanyRequestTest {
    private static Validator validator;

    @BeforeAll
    public static void init() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @DisplayName("업장의 이름은 빈 값일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    void validateName(String input) {
        // given
        PartnerCompanyRequest request = new PartnerCompanyRequest.Builder()
                .name(input)
                .build();

        // when
        Set<ConstraintViolation<PartnerCompanyRequest>> violations = validator.validate(request);
        ConstraintViolation<PartnerCompanyRequest> violation = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("name"))
                .findFirst()
                .get();

        // then
        assertThat(violation.getMessage()).isEqualTo("공백일 수 없습니다");
    }

    @DisplayName("업장의 이름은 32자를 넘을 수 없다.")
    @Test
    void validateNameLength() {
        // given
        PartnerCompanyRequest request = new PartnerCompanyRequest.Builder()
                .name("오늘은 기분이 좋아 라랄라라라라라라라라라라라라라라라라랄라라라라라라라라라라라라라라라 회사")
                .build();

        // when
        Set<ConstraintViolation<PartnerCompanyRequest>> violations = validator.validate(request);
        ConstraintViolation<PartnerCompanyRequest> violation = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("name"))
                .findFirst()
                .get();

        // then
        assertThat(violation.getMessage()).isEqualTo("크기가 0에서 32 사이여야 합니다");
    }

    @DisplayName("업장 지역은 16자를 넘을 수 없다.")
    @Test
    void validateLocationLength() {
        // given
        PartnerCompanyRequest request = new PartnerCompanyRequest.Builder()
                .location("서울시 강남구 테헤란로 스타벅스 옆에 있는 돈까스 가게 옆에 위치")
                .build();

        // when
        Set<ConstraintViolation<PartnerCompanyRequest>> violations = validator.validate(request);
        ConstraintViolation<PartnerCompanyRequest> violation = violations.stream()
                .filter(v -> v.getPropertyPath().toString().equals("location"))
                .findFirst()
                .get();

        // then
        assertThat(violation.getMessage()).isEqualTo("크기가 0에서 16 사이여야 합니다");
    }
}
