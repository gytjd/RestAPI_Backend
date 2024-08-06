package AWS6.APITest.service.message;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        // 메시지 처리 로직
    }
}