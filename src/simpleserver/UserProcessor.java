package simpleserver;

import com.google.gson.*;

public class UserProcessor extends Processor {

	public UserProcessor(String args) {
		if(args == "all") {
			processAll(someUserJsonArray);
		} else if(args > 0) { //by id
			process(someUser);
		}
	}

	@Override
	public String process(User user) {

		if(user == null) {
			return "Error: Null user";
		}
		this.type = "User";
		this.id = String.valueOf(user.getUserID());
		return "User id: "+user.getUserID()+" Username: "+user.getUsername();
	}

	public String[] processAll(JsonArray userArray) {
		String[] stringArray = new String[userArray.size()];
		for(int i : userArray.size()) {
			array[i] = userArray.get(i);
		}
		return stringArray;
	}
}
