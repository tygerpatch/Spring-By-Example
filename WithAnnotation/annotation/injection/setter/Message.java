package annotation.injection.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {
  private String str = null;

  public String getMessage() {
    return str;
  }

  @Autowired
  @Qualifier("annotation-setter-message")
  public void setMessage(String str) {
    this.str = str;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
    Message msg = (Message) context.getBean("annotation-setter-injection");

    System.out.println(msg.getMessage());
  }
}
