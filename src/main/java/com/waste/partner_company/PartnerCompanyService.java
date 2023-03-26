package com.waste.partner_company;

import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.CollectionAmountResponse;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
public class PartnerCompanyService {
    private final PartnerCompanyRepository partnerCompanyRepository;

    public PartnerCompanyService(PartnerCompanyRepository partnerCompanyRepository) {
        this.partnerCompanyRepository = partnerCompanyRepository;
    }

    public List<CollectionAmountResponse> find(Long id) {
        return partnerCompanyRepository.findAllWithHistoryAmount(id);
    }

    public void register(PartnerCompanyRequest request) {
        partnerCompanyRepository.save(request.toEntity());
    }
}
