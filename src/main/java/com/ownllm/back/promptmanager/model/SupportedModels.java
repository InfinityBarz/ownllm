package com.ownllm.back.promptmanager.model;

public enum SupportedModels {
    LLAMA_SMALL("lmstudio-community/Meta-Llama-3-8B-Instruct-GGUF/Meta-Llama-3-8B-Instruct-Q4_K_M.gguf");
    // Add more models here

    private final String key;

    SupportedModels(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
    }
