package com.ownllm.back.promptmanager;

import com.ownllm.back.promptmanager.controller.OwnLlmController;
import com.ownllm.back.promptmanager.service.OwnLLmService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.mockito.Mockito.*;

@SpringBootTest
public class ControllerTest {

    @InjectMocks
    OwnLlmController controller;

    @Mock
    OwnLLmService ownLLmService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldProcessFilesAndSendRequests() throws IOException {
        doNothing().when(ownLLmService).start(anyString());
    }

}