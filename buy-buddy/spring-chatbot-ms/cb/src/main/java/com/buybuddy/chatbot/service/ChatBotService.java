package com.buybuddy.chatbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

@Service
public class ChatBotService {

    @Value("${openai.api.key}")
    private String apiKey;

    @Value("${openai.api.url}")
    private String apiUrl;

    private final WebClient webClient = WebClient.builder().build();

    public String getChatResponse(String userMessage) {

    	String requestBody = "{\n" +
    		    "  \"model\": \"gpt-4.1-nano\",\n" +
    		    "  \"messages\": [\n" +
    		    "    {\"role\": \"system\", \"content\": \"You are a helpful e-commerce assistant.\"},\n" +
    		    "    {\"role\": \"user\", \"content\": \"" + userMessage + "\"}\n" +
    		    "  ]\n" +
    		    "}";

        Map response = webClient.post()
                .uri(apiUrl)
                .header("Authorization", "Bearer " + apiKey)
                .header("Content-Type", "application/json")
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        try {
            ObjectMapper mapper = new ObjectMapper();
            String reply = mapper.writeValueAsString(
                ((Map)((Map)((java.util.List) response.get("choices")).get(0)).get("message")).get("content")
            );
            return reply.replaceAll("\"", "");
        } catch (Exception e) {
            return "Error parsing response.";
        }
    }
}
