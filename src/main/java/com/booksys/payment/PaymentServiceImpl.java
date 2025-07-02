package com.booksys.payment;

import com.booksys.payment.dto.PaymentRequestDTO;
import com.booksys.payment.dto.PaymentResponseDTO;
import com.booksys.payment.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service implementation for managing payments.
 */
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentResponseDTO savePayment(PaymentRequestDTO requestDTO) {
        Payment payment = PaymentMapper.toEntity(requestDTO);
        Payment saved = paymentRepository.save(payment);
        return PaymentMapper.toDTO(saved);
    }

    @Override
    public PaymentResponseDTO getPaymentById(UUID id) {
        return paymentRepository.findById(id)
                .map(PaymentMapper::toDTO)
                .orElse(null);
    }

    @Override
    public void deletePayment(UUID paymentId) {
        paymentRepository.deleteById(paymentId);
    }

    @Override
    public List<PaymentResponseDTO> getPaymentsByBookingId(UUID bookingId) {
        return paymentRepository.findByBookingId(bookingId)
                .stream()
                .map(PaymentMapper::toDTO)
                .collect(Collectors.toList());
    }
}