package stuff;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // indicates that the class declares one or more bean definitions
public class MessageConfig {

  @Bean // ID is taken from method's name
  public Message message() {
    return new ConstructorMessage("Hello, from MessageConfig.");
  }

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(MessageConfig.class);
    Message msg = context.getBean(Message.class);
    System.out.println(msg.getMessage());
  }
}
