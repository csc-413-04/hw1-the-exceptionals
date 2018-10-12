package simpleserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ErrorProcessor implements Processor {

    //String idOfPost, content, content99;

    @Override
    public String process(String endpoint) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        ResponseInvalidError response = new ResponseInvalidError();
        response.setStatus("Error");
        return gson.toJson(response);
    }
}