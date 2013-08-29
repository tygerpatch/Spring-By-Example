package annotation.injection.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xml.injection.constructor.Message;

@Configuration
public class MessageConfig {

  @Bean
  public Message message() {
    return new Message("Hello, from MessageConfig.");
  }

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
    Message msg = context.getBean(Message.class);
    System.out.println(msg.getMessage());
  }
}
