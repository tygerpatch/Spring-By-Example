package xml.injection.setter;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Message {
  private String msg = null;

  public String getMessage() {
    return msg;
  }

  public void setMessage(String msg) {
    this.msg = msg;
  }

  public static void main(String[] args) {
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/xml/injection/resource/spring.xml"));
    Message msg = (Message) factory.getBean("setter-injection");
    System.out.println(msg.getMessage());
  }
}

