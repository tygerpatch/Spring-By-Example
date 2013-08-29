package annotation.injection.resource;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Resource(name = "resource-message")
  private String msg;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/annotation/resource/spring.xml");
    Message msg = (Message) context.getBean("resource-injection");

    System.out.println(msg.getMessage());
  }
}
