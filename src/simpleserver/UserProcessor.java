package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class UserProcessor extends Processor {

	private int entries = 0;
	private User[] userList;

	public UserProcessor() {
		try {
			db = new Database();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String process(String[] ep) {
		UserResponse ur = new UserResponse(db, ep);
		return ur.response();
	}

	/*
	 * @Override public String process(User user) {
	 * 
	 * if(user == null) { return "Error: Null user"; } this.type = "User"; this.id =
	 * String.valueOf(user.getUserID());
	 * System.out.println("User id: "+user.getUserID()+" Username: "+user.
	 * getUsername()); return
	 * "User id: "+user.getUserID()+" Username: "+user.getUsername(); }
	 */

	/*
	 * public String[] processAll(JsonArray userArray) { String[] stringArray = new
	 * String[userArray.size()]; for(int i = 0; i < userArray.size(); i++) {
	 * stringArray[i] = userArray.get(i).getAsString(); } return stringArray; }
	 */
}
