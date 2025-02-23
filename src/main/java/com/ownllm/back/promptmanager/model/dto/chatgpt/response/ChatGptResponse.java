package com.ownllm.back.promptmanager.model.dto.chatgpt.response;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.ownllm.back.promptmanager.model.dto.chatgpt.Choice;
import com.ownllm.back.promptmanager.model.dto.chatgpt.Usage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "object",
        "created",
        "model",
        "choices",
        "usage",
        "system_fingerprint"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatGptResponse {

    @JsonProperty("id")
    public String id;
    @JsonProperty("object")
    public String object;
    @JsonProperty("created")
    public Integer created;
    @JsonProperty("model")
    public String model;
    @JsonProperty("choices")
    public List<Choice> choices;
    @JsonProperty("usage")
    public Usage usage;
    @JsonProperty("system_fingerprint")
    public Object systemFingerprint;

}
