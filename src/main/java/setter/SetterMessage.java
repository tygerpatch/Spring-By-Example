package setter;

import basic.Message;

public class SetterMessage implements Message {
  private String message = null;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
