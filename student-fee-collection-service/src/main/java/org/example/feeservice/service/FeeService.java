package org.example.feeservice.service;

import org.example.feeservice.dto.FeeDTO;
import org.example.feeservice.entity.Receipt;
import org.example.feeservice.repository.ReceiptRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class FeeService {

    private final ReceiptRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();

    public FeeService(ReceiptRepository repository) {
        this.repository = repository;
    }

    public Receipt collectFee(FeeDTO feeDTO) {

        // Call student-service
        String url = "http://localhost:8081/api/students/" + feeDTO.getStudentId();
        StudentResponse student = restTemplate.getForObject(url, StudentResponse.class);

        if (student == null) {
            throw new RuntimeException("Student not found");
        }

        Receipt receipt = new Receipt();
        receipt.setStudentId(student.getStudentId());
        receipt.setStudentName(student.getStudentName());
        receipt.setGrade(student.getGrade());
        receipt.setSchoolName(student.getSchoolName());
        receipt.setFeeAmount(feeDTO.getFeeAmount());
        receipt.setPaymentMode(feeDTO.getPaymentMode());
        receipt.setPaymentDate(LocalDate.now());
        receipt.setReceiptNumber(UUID.randomUUID().toString());

        return repository.save(receipt);
    }

    public Receipt getReceipt(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receipt not found"));
    }

    public List<Receipt> getReceiptsByStudent(Long studentId) {
        return repository.findByStudentId(studentId);
    }

    // Inner DTO for student-service response
    static class StudentResponse {
        private Long studentId;
        private String studentName;
        private String grade;
        private String schoolName;

        public Long getStudentId() {
            return studentId;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getGrade() {
            return grade;
        }

        public String getSchoolName() {
            return schoolName;
        }
    }
}