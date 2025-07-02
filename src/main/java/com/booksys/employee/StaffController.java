package com.booksys.employee;
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


    @PostMapping("/save") //ok
    public ResponseEntity<Staff> save(@RequestBody Staff staff){
        return  new ResponseEntity<>(staffService.save(staff),HttpStatus.OK);
    }

    @GetMapping("/staffs/{name}") //ok
    public ResponseEntity<List<Staff>> findByNameStaff(@PathVariable String name ){
        return new ResponseEntity<>(staffService.findByName(name), HttpStatus.OK);
    }

    @GetMapping("/staff/{id}") //ok
    public ResponseEntity<Staff> findByid(@PathVariable UUID id){
        return new ResponseEntity<>(staffService.findByIdStaff(id),HttpStatus.OK);
    }

    @GetMapping("/all") //ok
    public ResponseEntity<List<Staff>> findAllStaff(){
        return new ResponseEntity<>(staffService.findAllStaff(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}") //ok
    public ResponseEntity<List<Staff>> deleteByIdStaff(@PathVariable UUID id){
        return new ResponseEntity<>(staffService.deleteStaffById(id),HttpStatus.OK);
    }
}
