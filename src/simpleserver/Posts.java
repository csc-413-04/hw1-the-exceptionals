package simpleserver;

public class Posts {
	private int userid;
	private int postid;
	private String postContent;

	// Constructor for the Post objects
	protected Posts(int userid, int postid, String postContent) {
		this.userid = userid;
		this.postid = postid;
		this.postContent = postContent;
	}

	public int getUserId() {
		return userid;
	}

	public int getPostID() {
		return postid;
	}

	public String getPostContent() {
		return postContent;
	}
}