package xml.injection.innerBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import xml.injection.constructor.Message;

// Requires the following jars: spring-beans.jar, spring-context.jar, spring-core.jar, spring-expression.jar
// Also needs Apache Commons Logging: commongs-logging.jar
public class Parrot {
  private Message message;

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public static void main(String[] args) {
    //XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/xml/injection/resource/spring.xml"));
    //Parrot bird = (Parrot) factory.getBean("inner-injection");

    ApplicationContext context = new ClassPathXmlApplicationContext("/xml/injection/resource/spring.xml");
    Parrot bird = (Parrot) context.getBean("inner-injection");

    Message msg = bird.getMessage();
    System.out.println(msg.getMessage());
  }
}
