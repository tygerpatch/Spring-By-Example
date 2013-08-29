package xml.injection.constructor;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Message {
  private String msg = null;

  public Message(String msg) {
    this.msg = msg;
  }

  public String getMessage() {
    return msg;
  }

  public void setup() {
    System.out.println("(Constructor Message) setup method called");
  }

  public void teardown() {
    System.out.println("(Constructor Message) teardown method called");
  }

  public static void main(String[] args) {
    // Note: Keep the following comments for future reference
    // Requires the following jars: spring-beans.jar, spring-context.jar, spring-core.jar, spring-expression.jar
    // Also needs Apache Commons Logging: commongs-logging.jar
    //
    // XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/with/xml/resource/spring.xml"));
    // Message msg = (Message) factory.getBean("constructor-injection");

    ApplicationContext context = new ClassPathXmlApplicationContext("/with/xml/resource/spring.xml");
    Message msg = (Message) context.getBean("constructor-injection");

    System.out.println(msg.getMessage());

    msg = (Message) context.getBean("setup-teardown");
    System.out.println(msg.getMessage());

    // The following removes the constructor-injection bean from the container.
    // But before the construcor-injection bean is removed, Spring calls the teardown method.
    BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
    registry.removeBeanDefinition("setup-teardown");
  }
}
