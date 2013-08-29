package annotation.injection.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Autowired
  @Qualifier("property-message")
  private String msg;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/annotation/resource/spring.xml");
    Message msg = (Message) context.getBean("property-injection");

    System.out.println(msg.getMessage());
  }
}
