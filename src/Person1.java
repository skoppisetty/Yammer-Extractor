
 
public class Person1 {
	  private int replied_to_id;
	  private String message_type ;
	  private body1 body ;
	  private int sender_id;
	  private String created_at ;
	  
	  private int thread_id;
	  private int id;
	  

	  // Getters and setters are not required for this example.
	  // GSON sets the fields directly.

	  @Override
	  public String toString() {
	    return id + "," + created_at + "," + replied_to_id + "," + body +"," ;
	  }
	}