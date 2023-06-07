package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dto.NotificationDTO;
import org.example.entity.Notification;
import org.example.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;


    public Notification sendMessage(NotificationDTO notificationDTO) {
        Notification notification = Notification.builder()
                .message(notificationDTO.getMessage())
                .sender(notificationDTO.getSender())
                .sentAt(LocalDateTime.now())
                .build();

        return notificationRepository.save(notification);
    }
}
