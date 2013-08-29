package annotation.injection.inject;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Inject
  @Named("inject-message")
  private String msg = null;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/annotation/resource/spring.xml");
    Message msg = (Message) context.getBean("inject-injection");

    System.out.println(msg.getMessage());
  }
}
