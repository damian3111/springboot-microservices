package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.NotificationDTO;
import org.example.service.NotificationService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> sendMessage(@RequestBody NotificationDTO notificationDTO){
    notificationService.sendMessage(notificationDTO);

    return ResponseEntity.ok("message has been sent");
    }

}
