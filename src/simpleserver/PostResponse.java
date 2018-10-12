package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PostResponse extends Response {

	ArrayList<String> posts;
	Posts post;
	int postLength;

	public PostResponse(Database db, String[] ep) { 
		if(ep.length == 2) {
			this.post = db.getPostbyID(Integer.parseInt(ep[1]));
		}
		/*
		 * if(id > 0 && postList != null && length >= 0) { this.postLength = length;
		 * this.id = String.valueOf(id); this.posts = postList; this.entries =
		 * posts.size(); this.success = true; } else if(id > 0 && postList != null &&
		 * length == -1) { this.entries = 1; this.postLength = length; this.id =
		 * String.valueOf(id); this.posts = postList; this.success = true; }
		 */
	}

	public class errorRes {
		String status;

		public errorRes() {
			this.status = "ERROR";
		}
	}

	public String response() {
		Gson gson = new Gson();
		return gson.toJson(post);

	}
}
