package br.com.ecosage.service;

import br.com.ecosage.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RabbitConsumer {

    private final List<String> userMessages = new ArrayList<>();
    private final List<String> aiResponses = new ArrayList<>();

    @RabbitListener(queues = RabbitMQConfig.USER_MESSAGES_QUEUE)
    public void consumeUserMessage(String message) {
        System.out.println("Mensagem do usuário consumida: " + message);
        userMessages.add(message);
    }

    @RabbitListener(queues = RabbitMQConfig.AI_RESPONSES_QUEUE)
    public void consumeAiResponse(String response) {
        System.out.println("Resposta do chatbot consumida: " + response);
        aiResponses.add(response);
    }

    public List<String> getUserMessages() {
        return new ArrayList<>(userMessages);
    }

    public List<String> getAiResponses() {
        return new ArrayList<>(aiResponses);
    }

    public void clearMessages() {
        userMessages.clear();
        aiResponses.clear();
    }
}
