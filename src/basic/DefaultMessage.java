package basic;

public class DefaultMessage implements Message {
  private String message = "Spring is fun.";

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
