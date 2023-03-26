package com.waste.partner_company;

import com.waste.common.ResponseMessage;
import com.waste.partner_company.dto.CollectionAmountResponse;
import com.waste.partner_company.dto.PartnerCompanyRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partner-company")
public class PartnerCompanyController {
    private final PartnerCompanyService partnerCompanyService;

    public PartnerCompanyController(PartnerCompanyService partnerCompanyService) {
        this.partnerCompanyService = partnerCompanyService;
    }

    @GetMapping("/{id}")
    public ResponseMessage<List<CollectionAmountResponse>> findAllWithAmount(@PathVariable Long id) {
        List<CollectionAmountResponse> results = partnerCompanyService.findAllWithAmount(id);
        return ResponseMessage.ok(results);
    }

    @PostMapping()
    public ResponseMessage<String> register(@Valid @RequestBody PartnerCompanyRequest request) {
        partnerCompanyService.register(request);
        return ResponseMessage.ok();
    }
}
