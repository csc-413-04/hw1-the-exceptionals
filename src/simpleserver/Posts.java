package simpleserver;

public class Posts {
	private int userid;
	private int postid;
	private String data;

	// Constructor for the Post objects
	protected Posts(int userid, int postid, String data) {
		this.userid = userid;
		this.postid = postid;
		this.data = data;
	}

	public int getUserId() {
		return userid;
	}

	public int getPostID() {
		return postid;
	}

	public String getPostContent() {
		return data;
	}
	
	public void setPostLength(int l) {
		data = data.substring(0, Math.min(data.length(), l));
	}
}