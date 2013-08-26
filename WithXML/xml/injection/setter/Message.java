package xml.injection.setter;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

// Requires the following jars: spring-beans.jar, spring-context.jar, spring-core.jar, spring-expression.jar
// Also needs Apache Commons Logging: commongs-logging.jar
public class Message {
  private String msg = null;

  public String getMessage() {
    return msg;
  }

  public void setMessage(String msg) {
    this.msg = msg;
  }

  public static void main(String[] args) {
    // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/xml/injection/resource/spring.xml"));
    // Message msg = (Message) factory.getBean("setter-injection");

    ApplicationContext context = new ClassPathXmlApplicationContext("/xml/injection/resource/spring.xml");
    Message msg = (Message) context.getBean("setter-injection");

    System.out.println(msg.getMessage());
  }
}

