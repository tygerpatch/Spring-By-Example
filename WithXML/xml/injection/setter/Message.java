package xml.injection.setter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {
  private String msg = null;

  public String getMessage() {
    return msg;
  }

  public void setMessage(String msg) {
    this.msg = msg;
  }

  private String otherMessage;

  public String getOtherMessage() {
    return otherMessage;
  }

  public void setOtherMessage(String msg) {
    this.otherMessage = msg;
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/xml/resource/spring.xml");
    Message msg = (Message) context.getBean("setter-injection");

    System.out.println(msg.getMessage());
    System.out.println(msg.getOtherMessage());
  }
}

