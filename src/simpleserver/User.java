package simpleserver;

public class User {
    private int userID;
    private String username;

    //Constructor for creating new user objects to add to the database
    protected User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }
}