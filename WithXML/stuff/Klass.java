package stuff;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Klass {
   private Message message;

   public Message getBean() {
      return message;
   }

   public void setBean(Message message) {
      this.message = message;
   }
   
   public static void main(String... args) {
      XmlBeanFactory factory = new XmlBeanFactory(new ClassPathResource("/spring.xml"));
      Klass klass = (Klass) factory.getBean("xml-inner-bean");      

      System.out.println(klass.getBean().getMessage());      
   }
}
