package simpleserver;

public class User {
	private int userid;
	private String username;

	// Constructor for creating new user objects to add to the database
	protected User(int userid, String username) {
		this.userid = userid;
		this.username = username;
	}

	public int getUserID() {
		return userid;
	}

	public String getUsername() {
		return username;
	}
}