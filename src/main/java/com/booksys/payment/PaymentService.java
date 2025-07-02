package com.booksys.payment;

import com.booksys.payment.dto.PaymentRequestDTO;
import com.booksys.payment.dto.PaymentResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing payments.
 */
public interface PaymentService {

    List<PaymentResponseDTO> getAllPayments();

    PaymentResponseDTO savePayment(PaymentRequestDTO requestDTO);

    PaymentResponseDTO getPaymentById(UUID id);

    void deletePayment(UUID paymentId);

    List<PaymentResponseDTO> getPaymentsByBookingId(UUID bookingId);
}
