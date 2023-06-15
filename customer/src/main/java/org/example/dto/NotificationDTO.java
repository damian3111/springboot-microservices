package org.example.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDTO {

    private String message;
    private String sender;
}
