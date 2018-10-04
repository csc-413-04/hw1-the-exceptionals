package simpleserver;

import com.google.gson.*;
import java.io.*;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class Database {

    protected static HashMap<String, User> userHashMap = new HashMap<>();
    protected static HashMap<String, Posts> postsHashMap = new HashMap<>();

    public Database() throws FileNotFoundException, UnsupportedEncodingException {

        InputStream dataStream = new FileInputStream("./Data/data.json");
        JsonParser parser = new JsonParser();
        JsonElement parsedObject = parser.parse(new InputStreamReader(dataStream, "UTF-8"));
        JsonObject baseObject = parsedObject.getAsJsonObject();
        JsonArray userArray = baseObject.getAsJsonArray();
        JsonArray postArray = baseObject.getAsJsonArray();

        //This for loop setup causes the loop to iterate through each object in the array.
        for(JsonElement retrievedUser : userArray){
            JsonObject retrievedUserObject = retrievedUser.getAsJsonObject();
            String UserUsername = retrievedUserObject.get("username").getAsString();
            int UserID = retrievedUserObject.get("userid").getAsInt();
            User userObject = new User(UserID, UserUsername);
            String UserIDString = Integer.toString(UserID);
            userHashMap.put(UserIDString, userObject);
        }

        for(JsonElement retrievedPost : postArray){
            JsonObject retrievedPostsObject = retrievedPost.getAsJsonObject();
            int PostID = retrievedPostsObject.get("postid").getAsInt();
            int UserID = retrievedPostsObject.get("userid").getAsInt();
            String postContent = retrievedPostsObject.get("data").getAsString();
            Posts postObject = new Posts(UserID, PostID, postContent);
            String postIDString = Integer.toString(PostID);
            postsHashMap.put(postIDString, postObject);
        }


    }

    //Note for Leslie: The following functions need to be fully implemented.
    //They should call upon the earlier user and post HashMaps to search through for the specified ID

    private static Posts errorPost = new Posts(-1, -1, "Error");
    private static User errorUser = new User(-1, "Error");
    static Collection<Posts> postsCollection = postsHashMap.values();
    static ArrayList<Posts> postsArrayList = new ArrayList<>(postsCollection);
    static Collection<User> userCollection = userHashMap.values();
    static ArrayList<User> userArrayList = new ArrayList<>(userCollection);

    public ArrayList<User> returnAllUsers(){
        return userArrayList;
    }

    /* Turns out, this getter was unnecessary.
    public User getUserbyUsername(String username){
        User user = errorUser;
        if(userHashMap.containsKey(username)) {
            user = userHashMap.get(username);
        }
        return user;
    }*/

    public User getUserbyID(int UserID){
        User user = errorUser;
        if(userHashMap.containsKey(Integer.toString(UserID))){
            user = userHashMap.get(Integer.toString(UserID));
        }
        return user;
    }

    public Posts getPostbyID(int postID){
        Posts post = errorPost;
        if(postsHashMap.containsKey(Integer.toString(postID))) {
            post = postsHashMap.get(Integer.toString(postID));
        }
        return post;
    }

    public Posts getPostbyLength(int maxLength){
        Posts post = errorPost;
        for(Posts testPost : postsArrayList){
            char[] postContentArray = (testPost.getPostContent()).toCharArray();
            if(postContentArray.length < maxLength){
                post = testPost;
                break;
            }
        }
        return post;
    }

}
