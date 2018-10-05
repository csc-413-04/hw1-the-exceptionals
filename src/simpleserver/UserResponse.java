package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class UserResponse extends Response{

   // String username;
    private ArrayList<String> users;
    private User user;

    public UserResponse(ArrayList<String> userList, int entries, int id) {
        if(entries > 1 && id != -1 && userList != null) { // Responds with all users
            this.entries = entries;
            this.success = true;
            this.users = userList;
        }  else {
            if(id > 0 && entries == 1 && userList != null) { // just one user
                this.user = new User(id, userList.get(id));
                this.id = String.valueOf(id);
                this.success = true;
            }
        }
    }

    public class errorRes {
        String status;
        public errorRes() {
            this.status = "ERROR";
        }
    }

    public void response() {
        Gson gson = new Gson();
        if(this.entries == 1 && Integer.parseInt(id) > 0 && success) { // response for a single user
            String json = gson.toJson(user);
        } else
        if(this.entries > 0 && Integer.parseInt(this.id) == -1 && success) { // response for all users
            String json = gson.toJson(users);

        } else {
            this.success = false;
            errorRes errorRes = new errorRes();
            String json = gson.toJson(errorRes);
        }


    }
}
