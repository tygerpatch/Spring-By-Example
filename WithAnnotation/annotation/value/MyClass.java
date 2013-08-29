package annotation.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyClass {

  @Value("Todd")
  private String firstName;

  @Value("false")
  private boolean flag;

  public String getFirstName() {
    return firstName;
  }

  public boolean isFlag() {
    return flag;
  }

  // TODO: Use the Spring Expression Language to dynamically wire a value in

//@Value("#{settlastName}")
//public String lastName;
//
//  public String getLastName() {
//    return lastName;
//  }

//  @Value("#{setter-injection")
//  private Message msg;
//
//  public Message getMsg() {
//    return msg;
//  }

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("/with/annotation/resource/spring.xml");
    MyClass bean = (MyClass) context.getBean("value-annotation");

    System.out.println("First Name: " + bean.getFirstName());
    System.out.println("Flag: " + bean.isFlag());

//  System.out.println("Last Name: " + bean.getLastName());
//    System.out.println("Message: " + bean.getMsg().getString());
  }

}
