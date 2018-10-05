package simpleserver;

import com.google.gson.Gson;

import java.util.ArrayList;

public class UserResponse extends Response{

   // String username;
    ArrayList<String> users;
    User user;

    public UserResponse(ArrayList<String> userList, int entries, int id) {
        if(entries > 1 && id != -1) { // Responds with all users
            this.entries = entries;
            this.success = true;
            this.users = userList;
        }  else {
            if(id > 0 && entries == 1) { // just one user
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
        if(this.entries == 1 && Integer.parseInt(id) > 0) {
            String json = gson.toJson(user);
        }
        if(this.entries > 0 && Integer.parseInt(this.id) == -1) {
            this.success = true;
            String json = gson.toJson(users);

        } else {
            this.success = false;
            errorRes errorRes = new errorRes();
            String json = gson.toJson(errorRes);
        }


    }
}
