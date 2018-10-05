package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class PostResponse extends Response {

    ArrayList<String> posts;

    public PostResponse(ArrayList<String> postList, int id, int length) { // if length = -1, we assume that length parameters were not specified

    }

    public void response() {
        Gson gson = new Gson();

    }
}
