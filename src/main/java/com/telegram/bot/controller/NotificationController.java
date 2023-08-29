package com.telegram.bot.controller;

import com.telegram.bot.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.telegram.bot.service.NotificationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/message")
public class NotificationController {

    private final NotificationService notificationService;

    @PostMapping("/send/telegram")
    public void sendTelegramNotification(@RequestBody NotificationRequest request) {
        notificationService.sendTelegramNotification(request);
    }

    @PostMapping("/sent/teams")
    public void sendTeamsNotification(@RequestBody NotificationRequest request) {
        notificationService.sendTeamsNotification(request);
    }
}