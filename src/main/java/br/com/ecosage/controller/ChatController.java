package br.com.ecosage.controller;

import br.com.ecosage.service.ChatService;
import br.com.ecosage.service.RabbitConsumer;
import br.com.ecosage.service.RabbitProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@CrossOrigin(origins = "http://localhost:5173")
public class ChatController {

    private final ChatService chatService;
    private final RabbitProducer rabbitProducer;
    private final RabbitConsumer rabbitConsumer;

    @Autowired
    public ChatController(ChatService chatService, RabbitProducer rabbitProducer, RabbitConsumer rabbitConsumer) {
        this.chatService = chatService;
        this.rabbitProducer = rabbitProducer;
        this.rabbitConsumer = rabbitConsumer;
    }

    @PostMapping()
    public String chat(@RequestBody String message) {
        rabbitProducer.sendUserMessage(message);

        String response = chatService.sentToAi(message);

        rabbitProducer.sendChatbotResponse(response);

        return "Mensagem enviada com sucesso!";
    }

    @GetMapping("/messages/user")
    public List<String> getUserMessages() {
        return rabbitConsumer.getUserMessages();
    }

    @GetMapping("/messages/ai")
    public List<String> getAiResponses() {
        return rabbitConsumer.getAiResponses();
    }

    @DeleteMapping("/messages")
    public String clearMessages() {
        rabbitConsumer.clearMessages();
        return "Mensagens limpas com sucesso!";
    }
}