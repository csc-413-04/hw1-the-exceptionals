package simpleserver;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private HashMap<String, User> userHashMap = new HashMap<>();
    private HashMap<String, Posts> postsHashMap = new HashMap<>();

    public Database() throws FileNotFoundException, UnsupportedEncodingException {

        InputStream dataStream = new FileInputStream("./Data/data.json");
        JsonParser parser = new JsonParser();
        JsonElement parsedObject = parser.parse(new InputStreamReader(dataStream, "UTF-8"));
        JsonObject baseObject = parsedObject.getAsJsonObject();
        JsonArray userArray = baseObject.getAsJsonArray();
        JsonArray postArray = baseObject.getAsJsonArray();

        //The following loop appears functional, but needs to be tested.
        //In particular, the UserUsername and UserID strings may not be correct.

        //This for loop setup causes the loop to iterate through each object in the array.
        for(JsonElement retrievedUser : userArray){
            JsonObject retrievedUserObject = retrievedUser.getAsJsonObject();

            //The following two lines retrieve the parts of the JsonObject with the corresponding member names.
            //It may not be fully functional and will await a proper test.
            String UserUsername = retrievedUserObject.get("username").getAsString();
            String UserID = retrievedUserObject.get("userID").getAsString();
            int userIDint = Integer.parseInt(UserID);
            User userObject = new User(userIDint, UserUsername);
            userHashMap.put(UserUsername, userObject);
        }


    }

    //Note for Leslie: The following functions need to be fully implemented.
    //They should call upon the earlier user and post HashMaps to search through for the specified ID

    public User getUserbyUsername(String username){
        return null;
    }

    public User getUserbyID(int UserID){
        return null;
    }

    public Posts getPostbyID(int postID){
        return null;
    }

    public Posts getPostbyLength(int postID, int maxLength){
        return null;
    }

}
