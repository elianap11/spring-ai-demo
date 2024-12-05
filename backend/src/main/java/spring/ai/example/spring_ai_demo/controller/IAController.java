package spring.ai.example.spring_ai_demo.controller;

import com.cohere.api.Cohere;
import com.cohere.api.resources.v2.requests.V2ChatRequest;
import com.cohere.api.types.ChatMessageV2;
import com.cohere.api.types.ChatResponse;
import com.cohere.api.types.UserMessage;
import com.cohere.api.types.UserMessageContent;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import spring.ai.example.spring_ai_demo.dto.SimpleMessage;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class IAController {

    private final Cohere cohere;

    public IAController(Cohere cohere) {
        this.cohere = cohere;
    }

    @PostMapping
    public ChatResponse chat(@RequestBody @Valid SimpleMessage simpleMessage) {
        try {
            if (simpleMessage == null || simpleMessage.getContent() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Content must not be empty");
            }

            UserMessageContent userMessageContent = UserMessageContent.of(simpleMessage.getContent());

            return cohere.v2()
                    .chat(
                            V2ChatRequest.builder()
                                    .model("command-r-plus")
                                    .messages(
                                            List.of(
                                                    ChatMessageV2.user(
                                                            UserMessage.builder()
                                                                    .content(userMessageContent)
                                                                    .build())))
                                    .build()
                    );

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error contacting the Cohere API", e);
        }
    }
}