package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Notification {

    @Id
    @SequenceGenerator(sequenceName = "notification_seq", name = "notification_gen")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_gen")
    private Long id;
    private String message;
    private String sender;
    private LocalDateTime sentAt;
}
