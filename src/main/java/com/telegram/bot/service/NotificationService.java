package com.telegram.bot.service;

import com.telegram.bot.dto.NotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class NotificationService {

    private final TelegramReportingService telegramReportingService;

    public void sendNotification(NotificationRequest request) {
        telegramReportingService.sendMessage(request.getMessage());
    }
}
