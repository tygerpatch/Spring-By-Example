package stuff;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import setter.SetterMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SetterMessageTest {
  // final Logger logger = LoggerFactory.getLogger(SetterMessageTest.class);

  @Autowired
  private SetterMessage message = null;

  @Test
  public void testMessage( ) {
    Assert.assertNotNull("Constructor message instance is null.", message);
    String msg = message.getMessage();
    Assert.assertNotNull("Message is null.", msg);
    String expectedMessage = "Spring is fun.";
    Assert.assertEquals("Message should be '" + expectedMessage + "'.", expectedMessage, msg);
    // logger.info("message='{}'", msg);
    System.out.println("message = '{}', msg = " + msg);
  }
}
