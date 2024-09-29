package com.ownllm.back.promptmanager.controller;

import com.ownllm.back.promptmanager.service.OwnLLmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j

@RestController
public class OwnLlmController {


    @Autowired
    private OwnLLmService ownLLmService;

    @GetMapping("/prompts")
    public void processFilesAndSendRequests(@RequestParam String str) {
        try {
            ownLLmService.start(str);
        } catch (Exception e) {
            log.error("Error while processing files and sending requests");
            e.printStackTrace();
        }
    }
}
