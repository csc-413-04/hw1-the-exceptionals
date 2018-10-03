package simpleserver;

import com.google.gson.*;
import java.io.*;
import java.util.HashMap;

public class Database {

    public static HashMap<String, User> userHashMap = new HashMap<>();
    public static HashMap<String, User> userIDHashMap = new HashMap<>();
    public static HashMap<String, Posts> postsHashMap = new HashMap<>();
    public static HashMap<String, Posts> postsLengthHashMap = new HashMap<>();

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
            userHashMap.put(UserUsername, userObject);
            userIDHashMap.put(UserIDString, userObject);
        }

        for(JsonElement retrievedPost : postArray){
            JsonObject retrievedPostsObject = retrievedPost.getAsJsonObject();
            int PostID = retrievedPostsObject.get("postid").getAsInt();
            int UserID = retrievedPostsObject.get("userid").getAsInt();
            String postContent = retrievedPostsObject.get("data").getAsString();
            int postLength = postContent.length();
            Posts postObject = new Posts(UserID, PostID, postContent);
            String postIDString = Integer.toString(PostID);
            postsHashMap.put(postIDString, postObject);
            postsHashMap.put(Integer.toString(postLength),postObject);
        }

    }

    //Note for Leslie: The following functions need to be fully implemented.
    //They should call upon the earlier user and post HashMaps to search through for the specified ID

    public User getUserbyUsername(String username){
        User user = userHashMap.get(username);
        return user;
    }

    public User getUserbyID(int UserID){
        User user = userIDHashMap.get(Integer.toString(UserID));
        return user;
    }

    public Posts getPostbyID(int postID){
        Posts post = postsHashMap.get(postID);
        return post;
    }

    public Posts getPostbyLength(int length){
        Posts post = postsLengthHashMap.get(Integer.toString(length));
        return post;
    }

}
