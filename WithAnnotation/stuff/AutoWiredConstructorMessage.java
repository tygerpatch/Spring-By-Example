package stuff;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWiredConstructorMessage implements Message {
   private Message msg;

   @Override
   public String getMessage() {
      return msg.getMessage();
   }
   
   @Override
   public void setMessage(String message) {
      // leave blank      
   }
   
   @Autowired
   // Note: The @Qualifier annotation cannot be used on the constructor.
   public AutoWiredConstructorMessage(SetterMessage msg) {
      this.msg = msg;
   }

   @PostConstruct
   public void setup() {
      System.out.println("Constructor Injection: setup method called");
   }

   @PreDestroy
   public void teardown() {
      System.out.println("Constructor Injection: teardown method called");
   }

   public static void main(String[] args) {
      ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
      Message msg = (Message) context.getBean("annotation-constructor-injection");

      System.out.println(msg.getMessage());

      // The following removes the constructor-injection bean from the container.
      // But before the construcor-injection bean is removed, Spring calls the teardown method.
      BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
      registry.removeBeanDefinition("annotation-constructor-injection");
   }
}
