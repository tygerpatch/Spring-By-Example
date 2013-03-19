package client;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.Message;

// Requires the following jars: spring-beans.jar, spring-context.jar, spring-core.jar, spring-expression.jar
// Also needs Apache Commons Logging: commongs-logging.jar
public class MessageRunner {
  // final static Logger logger = LoggerFactory.getLogger(MessageRunner.class);

  public static void main(String[] args) {
    File file = new File("src/client/application-context.xml");
    System.out.println("file.exists ? " + file.exists());

    // logger.info("Initializing Spring context.");
    System.out.println("Initializing Spring Context");
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/client/application-context.xml");
    // logger.info("Spring context initialized.");
    System.out.println("Spring context initialized");
    Message message = (Message) applicationContext.getBean("message");
    // logger.debug("message='" + message.getMessage() + "'");
    System.out.println("message = '" + message.getMessage() + "'");
  }
}
