package com.ownllm.back.promptmanager.model.dto.chatgpt.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ownllm.back.promptmanager.model.dto.chatgpt.Message;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "model",
        "messages",
        "temperature",
        "max_tokens",
        "top_p",
        "frequency_penalty",
        "presence_penalty",
        "stream"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChatGptRequest {

    @JsonProperty("model")
    public String model;
    @JsonProperty("messages")
    public List<Message> messages;
    @JsonProperty("temperature")
    public Double temperature;
    @JsonProperty("max_tokens")
    public Integer maxTokens;
    @JsonProperty("top_p")
    public Integer topP;
    @JsonProperty("frequency_penalty")
    public Integer frequencyPenalty;
    @JsonProperty("presence_penalty")
    public Integer presencePenalty;
    @JsonProperty("stream")
    public boolean stream;

}
