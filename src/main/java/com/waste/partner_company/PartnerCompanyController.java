package com.waste.partner_company;

import com.waste.partner_company.domain.PartnerCompany;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import jakarta.validation.Valid;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner-company")
public class PartnerCompanyController {
    private final PartnerCompanyService partnerCompanyService;

    public PartnerCompanyController(PartnerCompanyService partnerCompanyService) {
        this.partnerCompanyService = partnerCompanyService;
    }

    @GetMapping()
    public List<PartnerCompany> findAll() {
        return partnerCompanyService.findAll();
    }

    @PostMapping()
    public void register(@RequestBody PartnerCompanyRequest request) {
        partnerCompanyService.register(request);
    }
}
