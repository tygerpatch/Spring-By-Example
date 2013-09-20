package annotation.injection.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Inject
  @Named("annotation-inject-message")
  private String msg = null;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
    Message msg = (Message) context.getBean("annotation-inject-injection");

    System.out.println(msg.getMessage());
  }
}
