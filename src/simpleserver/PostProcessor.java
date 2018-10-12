package simpleserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PostProcessor implements Processor {

    String idOfPost, content, content99;
    @Override
    public String process(String endpoint) {
        String idOfPostString;
        // All logic goes in here
        //Check for third argument

        boolean toGetAllEndpoints = false;
        char [] c = endpoint.toCharArray();
        for (char i : c){
            if (i == '&'){
                toGetAllEndpoints = true;
            }
        }
        if (toGetAllEndpoints) {
            String[] request = endpoint.split("&");
            String contentString = request[1];
            contentString.trim();
            String [] request4 = contentString.split("=");
            if(request4[0].trim().equals("maxlength")){
                content = request4[1];
                content.trim();
                String request2[] = request[0].split("\\?");
                idOfPostString = request2[1];
                idOfPostString.trim();
                String[] request3 = idOfPostString.split("=");
                idOfPost = request3[1];
                idOfPost.trim();
            }
            else{
                idOfPost = request4[1];
                idOfPost.trim();
                String request2[] = request[0].split("\\?");
                idOfPostString = request2[1];
                idOfPostString.trim();
                String[] request3 = idOfPostString.split("=");
                content = request3[1];
                content.trim();
            }
        }
        else{
            String[] request = endpoint.split("\\?");
            idOfPostString = request[1];
            idOfPostString.trim();
            String[] request3 = idOfPostString.split("=");
            idOfPost = request3[1];
            idOfPost.trim();
        }

        //Posts[] post = null;
        //int postIdInt = Integer.parseInt(idOfPost);
        //Database db = Database.getDatabase();
        //post = db.getPostbyLength(postIdInt, Integer.parseInt(content));//set it equal to////

        //System.out.println(postIdInt + content);
//        if (postIdInt == -1 || content.trim().equals("Error")){
//            Response response = new Response();
//
//            //response.setData(db.getPostbyID(postIdInt));
//            response.setStatus("Error");
//            Gson gson = new Gson();
//            return gson.toJson(response);
//        }

        if (!toGetAllEndpoints) {
            int postIdInt = Integer.parseInt(idOfPost);
            Response response = new Response();
            Database db = Database.getDatabase();
            response.setData(db.getPostbyID(postIdInt));
            response.setStatus("OK");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(response);
        }
        else {
            Response response = new Response();
            ErrorResponse rp = new ErrorResponse();
            int postDataContent = Integer.parseInt(content);
            int postIdInt = Integer.parseInt(idOfPost);
            Database db = Database.getDatabase();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            if(db.checkForError(postIdInt, postDataContent) == 1){
                rp.setStatus("OK");
                return gson.toJson(rp);
            }
            else {
                response.setData(db.getPostbyLength(postIdInt, postDataContent));
                response.setStatus("OK");
                return gson.toJson(response);

            }

        }
    }

}
