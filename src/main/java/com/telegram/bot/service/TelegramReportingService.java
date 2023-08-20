package com.telegram.bot.service;

import com.telegram.bot.mybot.TelegramBot;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramReportingService {

    @Value("${telegram.bot.chatId}")
    private String chatId;

    private final TelegramBot telegramBot;

    public void sendMessage(String telegramMessage) {
        telegramBot.sendMessage(chatId, telegramMessage);
    }
}
