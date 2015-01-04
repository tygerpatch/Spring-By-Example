package stuff;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stuff.Message;

public class ResourceMessage implements Message {

   @Resource(name = "annotation-resource-message")
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
     Message msg = (Message) context.getBean("annotation-resource-injection");

     System.out.println(msg.getMessage());
   }
}
