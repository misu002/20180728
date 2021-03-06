package BeanModel;

public class Message {
	
//	private int id;
//	private String guestName;
	private int message_id;
	private String guest_name;


	private String password;
	private String message;
	
	public Message() {}
	
	public Message(String guestName, String password, String message) {
		super();
		this.guest_name = guestName;
		this.password = password;
		this.message = message;
	}
	
	public int getMessage_id() { return message_id; }
	public void setMessage_id(int message_id) { this.message_id = message_id; }
	public String getGuest_name() { return guest_name; }
	public void setGuest_name(String guest_name) { this.guest_name = guest_name; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getMessage() { return message; }
	public void setMessage(String message) { this.message = message; }
/*	public boolean hasPassword() { return password != null && !password.isEmpty(); }
	public boolean matchPassword(String pwd) {
	return password != null && password.equals(pwd); }*/

	@Override
	public String toString() {
		return "Message [message_id=" + message_id + ", guest_name=" + guest_name + ", password=" + password + ", message=" + message
				+ "]";
	}
	}