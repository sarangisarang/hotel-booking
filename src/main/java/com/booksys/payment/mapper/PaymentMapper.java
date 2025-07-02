package com.booksys.payment.mapper;

import com.booksys.payment.Payment;
import com.booksys.payment.PaymentStatus;
import com.booksys.payment.dto.PaymentRequestDTO;
import com.booksys.payment.dto.PaymentResponseDTO;

/**
 * Mapper class for converting between Payment entities and DTOs.
 */
public class PaymentMapper {

    public static PaymentResponseDTO toDTO(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setAmount(payment.getAmount());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setPaymentDate(payment.getPaymentDate().toLocalDate());
        dto.setStatus(String.valueOf(payment.getStatus()));
        return dto;
    }

    public static Payment toEntity(PaymentRequestDTO dto) {
        Payment payment = new Payment();
        payment.setAmount(dto.getAmount());
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setPaymentDate(dto.getPaymentDate().atStartOfDay());
        payment.setStatus(PaymentStatus.valueOf(dto.getStatus()));
        return payment;
    }
}

