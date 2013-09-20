package annotation.injection.property;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Autowired
  @Qualifier("annotation-property-message")
  private String msg;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
    Message msg = (Message) context.getBean("annotation-property-injection");

    System.out.println(msg.getMessage());
  }
}
