package org.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.dto.CustomerDTO;
import org.example.dto.NotificationDTO;
import org.example.entity.Customer;
import org.example.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Log4j2
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final WebClient webClient;

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("no such user"));
    }

    public Customer saveCustomer(CustomerDTO dto) {
        NotificationDTO notification = new NotificationDTO("message1", "sender1");

        String response = webClient
                .post()
                .uri("http://localhost:8081/v1/notification")
                .body(BodyInserters.fromValue(notification))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.info("reponse: " + response);


        Customer customer = Customer.builder()
                .age(dto.getAge())
                .email(dto.getEmail())
                .name(dto.getName())
                .build();

        return customerRepository.save(customer);
    }
}
