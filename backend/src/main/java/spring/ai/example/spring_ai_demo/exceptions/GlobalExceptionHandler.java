package spring.ai.example.spring_ai_demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException.class)
    public Map<String, String> handleResponseStatusException(ResponseStatusException ex) {
        return Map.of(
                "status", String.valueOf(ex.getStatusCode()),
                "message", ex.getReason()
        );
    }

    @ExceptionHandler(Exception.class)
    public Map<String, String> handleGenericException(Exception ex) {
        return Map.of(
                "status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()),
                "message", "An unexpected error occurred"
        );
    }
}

