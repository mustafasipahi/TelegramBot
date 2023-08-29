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
    private final TeamsReportingService teamsReportingService;

    public void sendTelegramNotification(NotificationRequest request) {
        telegramReportingService.sendMessage(request.getMessage());
    }

    public void sendTeamsNotification(NotificationRequest request) {
        teamsReportingService.sendMessage(request.getMessage());
    }
}
