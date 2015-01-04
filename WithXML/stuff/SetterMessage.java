package stuff;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMessage implements Message {

   private String msg;
   
   @Override
   public String getMessage() {
      return msg;
   }

   @Override
   public void setMessage(String msg) {
      this.msg = msg;      
   }

   private String otherMessage;

   public String getOtherMessage() {
     return otherMessage;
   }

   public void setOtherMessage(String msg) {
     this.otherMessage = msg;
   }

   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     Message msg = (Message) context.getBean("xml-setter-injection");

     System.out.println("Message: " + msg.getMessage());
     System.out.println("Other Message: " + ((SetterMessage)msg).getOtherMessage());
   }   
}
