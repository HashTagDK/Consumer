package pl.dk.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World CONSUMER";
    }

    @KafkaListener(topics = "test")
    public void listen(String message) {
        System.out.println("Received Messasge in group foo: " + message);
    }

    @KafkaListener(
            topics = "greeting",
            containerFactory = "greetingKafkaListenerContainerFactory")
    public void greetingListener(Greeting greeting) {
        System.out.println("Received Messasge in group foo: " + greeting.getName() + "-" + greeting.getMessage());
    }

}
