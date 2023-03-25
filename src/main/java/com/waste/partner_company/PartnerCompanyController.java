//package com.waste.collection.partner_company;
//
//import jakarta.validation.Valid;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/partner-company")
//public class PartnerCompanyController {
//
//    public PartnerCompanyController(TodoService todoService) {
//        this.todoService = todoService;
//    }
//
//    @GetMapping("/recent")
//    public ResponseMessage<List<TodoResponse>> findRecent(
//            @AuthenticationPrincipal LoginUser user,
//            @PageableDefault(size = 1, sort = "id", direction = Sort.Direction.DESC) Pageable pageable
//    ) {
//        List<TodoResponse> response = todoService.findRecent(user.getId(), pageable);
//        return response.isEmpty() ? ResponseMessage.noContent() : ResponseMessage.ok(response);
//    }
//
//    @GetMapping()
//    public PageResponse<List<TodoResponse>> findAll(@AuthenticationPrincipal LoginUser user, Pageable pageable) {
//        return todoService.findAll(user.getId(), pageable);
//    }
//
//    @PostMapping()
//    public ResponseMessage<String> createTodo(
//            @AuthenticationPrincipal LoginUser user,
//            @RequestBody @Valid TodoRequest request
//    ) {
//        todoService.createTodo(user.getId(), request);
//        return ResponseMessage.ok();
//    }
//
//    @PatchMapping("/{id}/status")
//    public ResponseMessage<String> updateStatus(
//            @PathVariable Long id,
//            @AuthenticationPrincipal LoginUser user,
//            @RequestBody @Valid TodoUpdateStatusRequest request
//    ) {
//        todoService.updateStatus(id, user.getId(), request);
//        return ResponseMessage.ok();
//    }
//}
