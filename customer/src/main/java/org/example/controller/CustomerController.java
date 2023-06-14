package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.CompletableFuture;

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

    @CircuitBreaker(name = "notification", fallbackMethod = "fallbackMethod2")
    @TimeLimiter(name = "notification")
    @PostMapping
    public CompletableFuture<String> getCustomer(@RequestBody CustomerDTO dto){

        return CompletableFuture.supplyAsync(() -> customerService.saveCustomer(dto));
    }

    public CompletableFuture<String> fallbackMethod2(CustomerDTO dto, Throwable runtimeException){
       return CompletableFuture.supplyAsync(() -> "error");
    }

}
