package annotation.injection.constructor;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Message {
  private String msg = null;

  @Autowired
  public Message(String msg) {
    this.msg = msg;
  }

  public String getMessage() {
    return msg;
  }

  @PostConstruct
  public void setup( ) {
    System.out.println("Constructor Injection: setup method called");
  }

  @PreDestroy
  public void teardown( ) {
    System.out.println("Constructor Injection: teardown method called");
  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/annotation/resource/spring.xml");
    Message msg = (Message) context.getBean("constructor-injection");

    System.out.println(msg.getMessage());

    // The following removes the constructor-injection bean from the container.
    // But before the construcor-injection bean is removed, Spring calls the teardown method.
    BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
    registry.removeBeanDefinition("constructor-injection");
  }
}
