package org.example.feeservice.repository;

import org.example.feeservice.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

    List<Receipt> findByStudentId(Long studentId);
}
