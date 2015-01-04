package stuff;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import annotation.injection.inject.Message;

public class InjectMessage implements Message {

   @Inject
   @Named("annotation-inject-message")
   private String msg = null;

   @Override
   public String getMessage() {
     return msg;
   }

   @Override
   public void setMessage(String str) {
      // leave blank
   }
   
   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     Message msg = (Message) context.getBean("annotation-inject-injection");

     System.out.println(msg.getMessage());
   }
}
