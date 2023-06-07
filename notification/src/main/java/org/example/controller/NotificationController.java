package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.NotificationDTO;
import org.example.entity.Notification;
import org.example.service.NotificationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping
    public Notification sendMessage(@RequestBody NotificationDTO notificationDTO){
        return notificationService.sendMessage(notificationDTO);
    }

}
