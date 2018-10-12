package simpleserver;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class Database {
    boolean check = false;
    User[] users = null;
    Posts[] posts = null;
    protected static HashMap<String, User> userHashMap = new HashMap<>();
    protected static HashMap<String, Posts> postsHashMap = new HashMap<>();
    boolean isLoaded = false;
    public static Database database = new Database();

    private Database () {

    }

    public static Database getDatabase() {
        if (!database.isLoaded) database.connect();
        return database;
    }

    public User[] getAllUsers() { return this.users; }



    void connect() {
        isLoaded = true;
        Gson gson = new Gson();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("src/data.json"));
            JsonParser jsonParser = new JsonParser();
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();

            users = gson.fromJson(obj.get("users"), User[].class);
            posts = gson.fromJson(obj.get("posts"), Posts[].class);// added this
            //.loadAll();

            //Put database objects into hashmaps
            for (User u : users) {
                String UserIDString = Integer.toString(u.getUserID());
                userHashMap.put(UserIDString, u);
            }

            for (Posts p : posts) {
                String PostIDString = Integer.toString(p.getPostID());
                postsHashMap.put(PostIDString, p);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //Methods to get users and posts

    Posts errorPost = new Posts(-1, -1, "Error");
    private static User errorUser = new User(-1, "Error");
    static Collection<Posts> postsCollection = postsHashMap.values();
    static ArrayList<Posts> postsArrayList = new ArrayList<>(postsCollection);
    static Collection<User> userCollection = userHashMap.values();
    static ArrayList<User> userArrayList = new ArrayList<>(userCollection);
    public User[] returnAllUsers() {
        return users;
    }

    /*
     * Turns out, this getter was unnecessary. public User getUserbyUsername(String
     * username){ User user = errorUser; if(userHashMap.containsKey(username)) {
     * user = userHashMap.get(username); } return user; }
     */

    public User[] getUserbyID(int UserID) {
        User user = errorUser;
        if (userHashMap.containsKey(Integer.toString(UserID))) {
            user = userHashMap.get(Integer.toString(UserID));
        }
        User[] us = {user};
        return us;
    }

    public Posts[] getPostbyID(int postID) {
        Posts post = errorPost;
        if (postsHashMap.containsKey(Integer.toString(postID))) {
            post = postsHashMap.get(Integer.toString(postID));
        }
        Posts[] po = {post};
        return po;
    }

    public Posts[] getPostbyLength(int postID, int maxLength) {
        Posts post = errorPost;

        if (postsHashMap.containsKey(Integer.toString(postID))) {
            post = postsHashMap.get(Integer.toString(postID));
        }
        Posts[] po = {post};
        char[] postContentArray = (post.getPostContent()).toCharArray();
        if (postContentArray.length <= maxLength) {
            return po;
        }
        else {
            post = errorPost;
            Posts[] postError = {post};
            return postError;
        }

    }
    public int checkForError(int postID, int maxLength){
        Posts post = errorPost;

        if (postsHashMap.containsKey(Integer.toString(postID))) {
            post = postsHashMap.get(Integer.toString(postID));
        }
        char[] postContentArray = (post.getPostContent()).toCharArray();
        if (postContentArray.length <= maxLength) {
            check = false;
        }
        else {
            check = true;
        }
        if (check == true){return 1;}
        else return 0;
    }


}
