package com.booksys.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booksys/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;


    @PostMapping("/save")
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        return  new ResponseEntity<>(staffService.save(staff),HttpStatus.OK);
    }

    @GetMapping("/staff/{name}")
    public ResponseEntity<List<Staff>> findByIdStaff(@PathVariable String name ){
        return new ResponseEntity<>(staffService.findByName(name), HttpStatus.OK);
    }

}
