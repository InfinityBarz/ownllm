package com.ownllm.back.promptmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ownllm.back.promptmanager.model.SupportedModels;
import com.ownllm.back.promptmanager.model.dto.chatgpt.request.ChatGptRequest;
import com.ownllm.back.promptmanager.model.dto.chatgpt.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Collections;

@Slf4j
@Service
public class OwnLLmService {

    public static final String URL = "http://localhost:1234/v1/chat/completions";
    @Autowired
    private HttpClient httpClient;

    private ObjectMapper objectMapper = new ObjectMapper();


    public void start(String str) {
        log.info("start Starting the service");
        try {
            log.info(str);
        } catch (Exception e) {
            log.error("Error while starting the service");
            e.printStackTrace();
        }
    }

    private void askForData(String fileName, String fileContent) {
        log.info("askForData Asking for data for file: {}", fileName);
        try {
            sendHttpRequest(objectMapper.writeValueAsString(createRequest(fileName, fileContent)));
        } catch (Exception e) {
            log.error("Error while sending request for file: " + fileName);
            e.printStackTrace();
        }
    }

    private ChatGptRequest createRequest(String fileName, String fileContent) {
        log.info("createRequest Creating request for file: {}", fileName);
        Message message = new Message("user", "You are JSON parser machine, your job is to answer only with JSON code");
        return ChatGptRequest.builder()
                .model(SupportedModels.LLAMA_SMALL.getKey())
                .messages(Collections.singletonList(message))
                .maxTokens(1)
                .temperature(0.7)
                .topP(5)
                .frequencyPenalty(0)
                .presencePenalty(0)
                .stream(true)
                .build();

    }

    private void sendHttpRequest(String json) {
        log.info("sendHttpRequest Sending request: {}", json);
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Response received: {}", response.body());
        } catch (Exception e) {
            log.error("Error while sending request");
            e.printStackTrace();
        }
    }
}