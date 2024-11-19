package br.com.ecosage.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Você é um chatbot expecializado em enviar url de imagens.
                        Você participa em um programa de gerenciamento de energia elétrica.
                        """)
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
                )
                .build();
    }

    public String sentToAi(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();

    }


}