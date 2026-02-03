package org.example.feeservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.feeservice.dto.FeeDTO;
import org.example.feeservice.entity.Receipt;
import org.example.feeservice.service.FeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fees")
@Tag(name = "Fee APIs", description = "APIs for fee collection and receipts")
public class FeeController {

    private final FeeService feeService;

    public FeeController(FeeService feeService) {
        this.feeService = feeService;
    }

    @Operation(summary = "Collect fee and generate receipt")
    @PostMapping("/collect")
    public ResponseEntity<Receipt> collectFee(@Valid @RequestBody FeeDTO dto) {
        Receipt receipt = feeService.collectFee(dto);
        return new ResponseEntity<>(receipt, HttpStatus.CREATED);
    }

    @Operation(summary = "Get receipt by ID")
    @GetMapping("/receipt/{id}")
    public ResponseEntity<Receipt> getReceiptById(@PathVariable Long id) {
        return ResponseEntity.ok(feeService.getReceipt(id));
    }

    @Operation(summary = "Get receipts by student ID")
    @GetMapping("/receipts/student/{studentId}")
    public ResponseEntity<List<Receipt>> getReceiptsByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(feeService.getReceiptsByStudent(studentId));
    }
}