package com.booksys.payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/save") //ok
    public ResponseEntity<Payment> save(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.save(payment), HttpStatus.OK);
    }

    @GetMapping("/payments/{id}") // ok
    public ResponseEntity<Payment> findByIdPayment(@PathVariable UUID id){
        return new ResponseEntity<>(paymentService.findById(id),HttpStatus.OK);
    }

    @GetMapping("/all") //ok
    public ResponseEntity<List<Payment>> findAll(){
        return new ResponseEntity<>(paymentService.findAll(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //ok
    public ResponseEntity<Payment> deletePaymentById(@PathVariable UUID id){
        paymentService.deletePaymentById(id);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
