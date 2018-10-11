package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PostResponse extends Response {

	ArrayList<String> posts;
	Posts post;
	int postLength;

	public PostResponse(Database db, String[] ep) { // if length = -1, we assume that length parameters were not
													// specified
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
		if (this.success && this.postLength == -1 && Integer.parseInt(this.id) > 0) {
			String json = gson.toJson(posts.get(Integer.parseInt(this.id)));
		} else if (this.success && this.postLength > 0 && Integer.parseInt(this.id) > 0) {
			String json = gson.toJson(posts);
		}
		return id;

	}
}
