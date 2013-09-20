package annotation.injection.resource;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {

  @Resource(name = "annotation-resource-message")
  private String msg;

  public String getMessage() {
    return msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
    Message msg = (Message) context.getBean("annotation-resource-injection");

    System.out.println(msg.getMessage());
  }
}
