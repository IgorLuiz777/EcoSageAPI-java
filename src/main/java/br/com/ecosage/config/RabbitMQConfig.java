package br.com.ecosage.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String USER_MESSAGES_QUEUE = "user-messages-queue";
    public static final String AI_RESPONSES_QUEUE = "ai-responses-queue";

    public static final String USER_MESSAGES_EXCHANGE = "user-messages-exchange";
    public static final String AI_RESPONSES_EXCHANGE = "ai-responses-exchange";

    public static final String USER_MESSAGES_ROUTING_KEY = "user-messages-key";
    public static final String AI_RESPONSES_ROUTING_KEY = "ai-responses-key";

    @Bean
    public Queue userMessagesQueue() {
        return new Queue(USER_MESSAGES_QUEUE, true);
    }

    @Bean
    public Queue chatbotResponsesQueue() {
        return new Queue(AI_RESPONSES_QUEUE, true);
    }

    @Bean
    public TopicExchange userMessagesExchange() {
        return new TopicExchange(USER_MESSAGES_EXCHANGE);
    }

    @Bean
    public TopicExchange chatbotResponsesExchange() {
        return new TopicExchange(AI_RESPONSES_EXCHANGE);
    }

    @Bean
    public Binding userMessagesBinding() {
        return BindingBuilder.bind(userMessagesQueue()).to(userMessagesExchange()).with(USER_MESSAGES_ROUTING_KEY);
    }

    @Bean
    public Binding chatbotResponsesBinding() {
        return BindingBuilder.bind(chatbotResponsesQueue()).to(chatbotResponsesExchange()).with(AI_RESPONSES_ROUTING_KEY);
    }
}
