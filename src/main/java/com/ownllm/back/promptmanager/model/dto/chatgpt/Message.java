package com.ownllm.back.promptmanager.model.dto.chatgpt;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "role",
        "content"
})
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

    @JsonProperty("role")
    public String role;
    @JsonProperty("content")
    public String content;

}