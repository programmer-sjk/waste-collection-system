package com.waste.partner_company;

import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.CollectionAmountResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerCompanyRepository extends JpaRepository<PartnerCompany, Long> {
    @Query(value = """
        SELECT new com.waste.partner_company.dto.CollectionAmountResponse(p.name, p.location, c.amount, c.boxCount)
        FROM PartnerCompany p
        INNER JOIN CollectionHistory c ON c.partnerCompanyId = p.id
        WHERE p.id = :id
    """)
    List<CollectionAmountResponse> findAllWithHistoryAmount(@Param("id") Long id);
}
