package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.CustomerDTO;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("no such user"));
    }

    public Customer saveCustomer(CustomerDTO dto) {
        Customer customer = Customer.builder()
                .age(dto.getAge())
                .email(dto.getEmail())
                .name(dto.getName())
                .build();

        return customerRepository.save(customer);
    }
}
