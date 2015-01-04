package stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stuff.Message;

public class AutoWiredPrivateFieldMessage implements Message {

   @Autowired
   @Qualifier("annotation-property-message")
   private String msg;
      
   @Override
   public String getMessage() {
      return msg;
   }

   @Override
   public void setMessage(String message) {
      // leave blank      
   }

   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     Message msg = (Message) context.getBean("annotation-property-injection");

     System.out.println(msg.getMessage());
   }   
}
