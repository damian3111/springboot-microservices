package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "customer")
public class Customer {

    @Id
    @SequenceGenerator(sequenceName = "customer_seq", name = "customer_gen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_gen")
    private Long id;
    private String name;
    private String email;
    private int age;
}
