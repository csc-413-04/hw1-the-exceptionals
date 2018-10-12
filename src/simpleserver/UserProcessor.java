package simpleserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class UserProcessor implements Processor{

    @Override
    public String process(String endpoint) {
        // All logic goes in here
        //DO code for displaying all users, or displaying user by id.
        if (endpoint.trim().equals("/user")) {
            Response response = new Response();
            Database db = Database.getDatabase();
            response.setData(db.getAllUsers());
            response.setStatus("OK");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(response);
        }
        else {
            String[] request = endpoint.split("\\?");
            String userId = request[1];
            userId.trim();
            Response response = new Response();
            String [] userIdString = userId.split("=");
            String userIdString2 = userIdString[1];
            System.out.println(userIdString2);
            int userIdInt = Integer.parseInt(userIdString2);
            Database db = Database.getDatabase();
            response.setData(db.getUserbyID(userIdInt));
            response.setStatus("OK");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(response);
        }
    }
}
