package com.booksys.payment;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService{

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment save(Payment payment) {
        return null;
    }

    @Override
    public void deletePaymentById(UUID payimentId) {
       Payment payment = (Payment) paymentRepository.findBypaymentID(payimentId).orElseThrow();
       paymentRepository.delete(payment);
    }

    @Override
    public List<Payment> findByName(String name) {
        return null;
    }

    @Override
    public Payment findById(UUID id) {
        return (Payment) paymentRepository.findBypaymentID(id).orElseThrow();
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }
}
