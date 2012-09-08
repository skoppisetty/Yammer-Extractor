
import java.util.List;

public class Messages{
   	//private List<Attachments> attachments;
   	private Body body;
   	//private String chat_client_sequence;
   	//private String client_type;
   	//private String client_url;
   	private String created_at;
   //	private boolean direct_message;
   	//private Number group_id;
   	private Number id;
   	/*
   	private Liked_by liked_by;
   	private String message_type;
   	private Number network_id;
   	private String privacy;
   	*/
   	private String replied_to_id;
   	
   	private Number sender_id;
   	/*
   	private String sender_type;
   	private boolean system_message;
   	private Number thread_id;
   	private String url;
   	private String web_url;
   	*/

   	public String toString() {
	    return  "\n" + id + "\t" + created_at + "\t" + replied_to_id + "\t" + sender_id + "\t"+ body;
	  }
}
