package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class UserResponse extends Response {

	// String username;
	private User[] users = null;
	private User user = null;

	public UserResponse(Database db, String[] ep) {
		if (ep.length == 1 /* && id != -1 && userList != null */) { // Responds with all users
			this.entries = ep.length;
			this.success = true;
			this.users = db.returnAllUsers();
		} else {
			if (Integer.parseInt(ep[1]) > 0 /* && entries == 1 && userList != null */) { // just one user
				this.entries = ep.length;
				this.id = ep[1];
				this.user = db.getUserbyID(Integer.parseInt(ep[1]));
				this.success = true;
			}
		}
	}

	public class errorRes {
		String status;

		public errorRes() {
			this.status = "ERROR";
		}
	}

	public String response() {
		Gson gson = new Gson();
		if (this.entries == 1 && success) { // response for a all user
			String json = gson.toJson(users);
			return json;
		} else if (this.entries > 1 && Integer.parseInt(this.id) > 0 && success) { // response for single users
			String json = gson.toJson(user);
			return json;
		} else {
			this.success = false;
			errorRes errorRes = new errorRes();
			String json = gson.toJson(errorRes);
			return json;
		}
	}
}
