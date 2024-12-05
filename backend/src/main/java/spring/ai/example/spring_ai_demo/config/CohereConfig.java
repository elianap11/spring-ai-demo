package spring.ai.example.spring_ai_demo.config;

import com.cohere.api.Cohere;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CohereConfig {

    @Value("${cohere.api.key}")
    private String apiKey;

    @Value("${client.name}")
    private String clientName;

    @Bean
    public Cohere cohere() {
        return Cohere.builder()
                .token(apiKey)
                .clientName(clientName)
                .build();
    }
}
