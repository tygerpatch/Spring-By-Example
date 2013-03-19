package constructor;

import basic.Message;

public class ConstructorMessage implements Message {
  private String message = null;

  public ConstructorMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
