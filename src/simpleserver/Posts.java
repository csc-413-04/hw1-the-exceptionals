package simpleserver;

public class Posts{
    public int userID;
    private int postID;
    private String postContent;

    //Constructor for the Post objects
    public Posts(int userID, int postID, String postContent){
        this.userID = userID;
        this.postID = postID;
        this.postContent = postContent;
    }
    public int getUserId(){
        return userID;
    }
    public int getPostID(){
        return postID;
    }
    public String getPostContent(){
        return postContent;
    }
}