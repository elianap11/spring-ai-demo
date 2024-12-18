package spring.ai.example.spring_ai_demo.dto;

import jakarta.validation.constraints.NotBlank;

public class SimpleMessage {

    @NotBlank(message = "Content must not be empty")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

