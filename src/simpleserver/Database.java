package simpleserver;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Database {

    private HashMap<String, User> userHashMap = new HashMap<>();
    private HashMap<String, Posts> postsHashMap = new HashMap<>();

    public Database() throws Exception{

        InputStream dataStream = new FileInputStream("./Data/data.json");
        JsonParser parser = new JsonParser();
        JsonElement parsedObject = parser.parse(new InputStreamReader(dataStream, "UTF-8"));
        JsonObject baseObject = parsedObject.getAsJsonObject();
        JsonArray userArray = new JsonArray();
        JsonArray postArray = new JsonArray();

        /*
        To be added: loops and/or methods to add objects contained within the baseObject JsonObject to convert
        to string and add them to the proper HashMap
         */


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
