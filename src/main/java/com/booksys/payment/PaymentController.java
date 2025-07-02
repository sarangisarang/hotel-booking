package com.booksys.payment;

import com.booksys.payment.dto.PaymentRequestDTO;
import com.booksys.payment.dto.PaymentResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * REST controller for managing payments.
 */
@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PaymentController {

    private final PaymentService paymentService;

    /**
     * Retrieve all payments.
     */
    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAllPayments() {
        List<PaymentResponseDTO> payments = paymentService.getAllPayments();
        return ResponseEntity.ok(payments);
    }

    /**
     * Create a new payment.
     */
    @PostMapping
    public ResponseEntity<PaymentResponseDTO> createPayment(
            @Valid @RequestBody PaymentRequestDTO requestDTO) {
        PaymentResponseDTO createdPayment = paymentService.savePayment(requestDTO);
        return ResponseEntity.ok(createdPayment);
    }

    /**
     * Retrieve a payment by its ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getPaymentById(@PathVariable UUID id) {
        PaymentResponseDTO payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Delete a payment by its ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable UUID id) {
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Retrieve payments by booking ID.
     */
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<PaymentResponseDTO>> getPaymentsByBookingId(@PathVariable UUID bookingId) {
        List<PaymentResponseDTO> payments = paymentService.getPaymentsByBookingId(bookingId);
        return ResponseEntity.ok(payments);
    }
}