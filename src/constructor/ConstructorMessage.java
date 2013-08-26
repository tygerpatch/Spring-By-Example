package constructor;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class ConstructorMessage {
  private String message = null;

  public ConstructorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public static void main(String[] args) {
    XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/constructor/ConstructorMessage-context.xml"));

    ConstructorMessage obj = (ConstructorMessage) factory.getBean("message");
    String msg = obj.getMessage();
    System.out.println(msg);
  }
}
