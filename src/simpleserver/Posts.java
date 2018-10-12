package simpleserver;

public class Posts extends iData{
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
    public String getPostContent(){
        return data;
    }
//    @Override
//    public boolean equals(Posts other) {
//        if (!(other instanceof Posts)) {
//            return false;
//        }
//
//        Posts that = (Posts) other;
//
//        // Custom equality check here.
//        return this.data.equals(that.data);
//    }
}