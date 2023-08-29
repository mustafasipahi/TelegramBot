package com.telegram.bot.service;

import com.telegram.bot.dto.TeamsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class TeamsReportingService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${teams-service.url}")
    private String webHookUrl;

    public void sendMessage(String teamsMessage) {

        final TeamsRequest teamsRequest = TeamsRequest.builder()
                .text(teamsMessage)
                .build();

        restTemplate.postForEntity(webHookUrl, teamsRequest, String.class);
    }
}
