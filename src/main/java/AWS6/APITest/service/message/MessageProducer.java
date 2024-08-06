package AWS6.APITest.service.message;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageProducer {

    private final RabbitTemplate rabbitTemplate;
    private final String queueName;

    public MessageProducer(RabbitTemplate rabbitTemplate, @Value("${queue.name}") String queueName) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueName = queueName;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend(queueName, message);
    }
}