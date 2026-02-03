package org.example.feeservice.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO for Fee collection
 */
@Data                  // Generates getters, setters, toString, equals & hashCode
@NoArgsConstructor     // No-args constructor
@AllArgsConstructor    // All-args constructor
public class FeeDTO {

    @NotNull(message = "Student ID is mandatory")
    private Long studentId;

    @Min(value = 1, message = "Fee amount must be at least 1")
    private double feeAmount;

    @NotBlank(message = "Payment mode is mandatory")
    private String paymentMode;
}