package br.com.ecosage.service;

import br.com.ecosage.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserMessage(String message) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.USER_MESSAGES_EXCHANGE, RabbitMQConfig.USER_MESSAGES_ROUTING_KEY, message);
        System.out.println("Mensagem do usuário enviada para o RabbitMQ");
    }

    public void sendChatbotResponse(String response) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.AI_RESPONSES_EXCHANGE, RabbitMQConfig.AI_RESPONSES_ROUTING_KEY, response);
        System.out.println("Resposta do chatbot enviada para o RabbitMQ");
    }
}
