package org.example.feeservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "receipts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receiptId;

    private Long studentId;
    private String studentName;
    private String grade;
    private String schoolName;

    private Double feeAmount;
    private String paymentMode;
    private LocalDate paymentDate;
    private String receiptNumber;
}
