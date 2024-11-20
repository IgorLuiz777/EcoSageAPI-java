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
                        Você é um chatbot d EcoSage você expecializado em enviar dicas sobre consumo de energia.
                        Você participa em um sistema de gerenciamento de energia elétrica.
                        Você será perguntado sobre todo tipo de ajudar sobre o tema economia de energia,consumo inteligente
                        energia limpa e derivados. Se a pergunta não for relacionada ao tema diga que não pode responder.
                        Não se esqueça que o público alvo é o brasileiro pense nisso antes de enviar a resposta.
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