package com.telegram.bot.mybot;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Setter
public class TelegramBot extends TelegramWebhookBot {

    private String token;
    private String username;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return null;
    }

    public void sendMessage(String chatId, String telegramMessage) {
        try {
            final SendMessage sendMessage = new SendMessage(chatId, telegramMessage);
            sendMessage.enableHtml(true);
            executeAsync(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Something wrong when send telegram message", e);
        }
    }
}
