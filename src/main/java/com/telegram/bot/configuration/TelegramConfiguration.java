package com.telegram.bot.configuration;

import com.telegram.bot.mybot.TelegramBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class TelegramConfiguration {

    @Bean
    public TelegramBotsApi telegramBotsApi() {
        try {
            return new TelegramBotsApi(DefaultBotSession.class);
        } catch (TelegramApiException e) {
            throw new IllegalStateException(e);
        }
    }

    @Bean
    public TelegramBot telegramBot(Environment environment) {
        TelegramBot telegramBot = new TelegramBot();
        telegramBot.setToken(environment.getProperty("telegram.bot.token"));
        telegramBot.setUsername(environment.getProperty("telegram.bot.username"));
        return telegramBot;
    }
}
