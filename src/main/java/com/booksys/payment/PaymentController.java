package com.booksys.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/booksys/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save")
    public ResponseEntity<Payment> save(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.OK);
    }
    @GetMapping("/payments/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id){
        return new ResponseEntity<>(paymentService.findById(id),HttpStatus.OK);
    }
}
