package stuff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import stuff.Message;

public class AutoWiredSetterMessage implements Message {

   private String msg;
   
   @Override
   public String getMessage() {
      return msg;
   }

   @Override
   @Autowired
   @Qualifier("annotation-setter-message")   
   public void setMessage(String msg) {
     this.msg = msg;
   }

   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     Message msg = (Message) context.getBean("annotation-setter-injection");

     System.out.println(msg.getMessage());
   }   
   
}
