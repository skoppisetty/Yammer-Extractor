public class body1 {
  private String parsed;
  private String rich;
  private String plain;
  

  // Getters and setters are not required for this example.
  // GSON sets the fields directly.

  @Override
  public String toString() {
    return rich + " - ";
  }
}