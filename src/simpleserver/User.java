package simpleserver;

public class User {
    public int userID;
    public String username;

    //Constructor for creating new user objects to add to the database
    private User(int userID, String username) {
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