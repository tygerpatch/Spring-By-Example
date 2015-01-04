package stuff;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ValueAnnotation {

   @Value("Todd")
   private String firstName;

   public String getFirstName() {
      return firstName;
   }

   @Value("false")
   private boolean flag;

   public boolean isFlag() {
      return flag;
   }

   @Value("#{lastName}")
   private String lastName;

   public String getLastName() {
      return lastName;
   }

   public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml");
     ValueAnnotation bean = (ValueAnnotation) context.getBean("annotation-value-annotation");

     System.out.println("Flag: " + bean.isFlag());
     
     System.out.println("First Name: " + bean.getFirstName());
     System.out.println("Last Name: " + bean.getLastName());
   }
}
