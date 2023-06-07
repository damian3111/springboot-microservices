package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/{id}")
    public ResponseEntity getCustomer(@PathVariable("id") Long id){
        try {
            return ResponseEntity.ok(customerService.getCustomer(id));
        }catch (RuntimeException r){
            return ResponseEntity.badRequest().body(r.getMessage());
        }
    }

    @PostMapping
    public Customer getCustomer(@RequestBody CustomerDTO dto){
        return customerService.saveCustomer(dto);
    }
}
