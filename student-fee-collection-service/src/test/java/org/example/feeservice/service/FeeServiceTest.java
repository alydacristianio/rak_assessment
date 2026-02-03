package org.example.feeservice.service;

import org.example.feeservice.dto.FeeDTO;
import org.example.feeservice.entity.Receipt;
import org.example.feeservice.repository.ReceiptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class FeeServiceTest {

    private final ReceiptRepository repo = mock(ReceiptRepository.class);
    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final FeeService service = new FeeService(repo);

    @Test
    void testCollectFee() {
        FeeDTO dto = new FeeDTO();
        dto.setStudentId(1L);
        dto.setFeeAmount(5000);
        dto.setPaymentMode("CASH");
        when(restTemplate.getForObject(anyString(), eq(Object.class))).thenReturn(new Object());
        Receipt saved = new Receipt();
        saved.setFeeAmount(5000.0);
        when(repo.save(any(Receipt.class))).thenReturn(saved);
        Receipt result = service.collectFee(dto);
        assertEquals(5000.0, result.getFeeAmount());
        verify(repo, times(1)).save(any(Receipt.class));
    }

    @Test
    void testGetReceiptById() {
        Receipt receipt = new Receipt();
        receipt.setReceiptNumber("RCP-001");
        when(repo.findById(1L)).thenReturn(Optional.of(receipt));
        Receipt result = service.getReceipt(1L);
        assertEquals("RCP-001", result.getReceiptNumber());
    }

    @Test
    void testGetReceiptsByStudent() {
        when(repo.findByStudentId(1L)).thenReturn(List.of(new Receipt(), new Receipt()));
        List<Receipt> receipts = service.getReceiptsByStudent(1L);
        assertEquals(2, receipts.size());
    }
}
