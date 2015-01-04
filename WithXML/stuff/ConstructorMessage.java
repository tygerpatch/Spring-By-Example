package stuff;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConstructorMessage implements Message {

   private String msg = null;

   public ConstructorMessage(String msg) {
      this.msg = msg;
   }
   
   @Override
   public String getMessage() {
      return msg;
   }

   @Override
   public void setMessage(String msg) {
      // leave blank
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

     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     
     Message msg = (Message) context.getBean("xml-constructor-injection");

     System.out.println(msg.getMessage());
     System.out.println("-------");

     msg = (Message) context.getBean("xml-setup-teardown");
     System.out.println(msg.getMessage());

     // The following removes the constructor-injection bean from the container.
     // But before the construcor-injection bean is removed, Spring calls the teardown method.
     BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();
     registry.removeBeanDefinition("xml-setup-teardown");
   }      
}
