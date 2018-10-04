package simpleserver;

public class UserResponse extends Response{

    int[] ids;
    String username;
    String[] usernames;

    public void response() {

    }

    public void response(int entries, int id) {
        if(entries > 0 && id > 0) {
            this.success = true;
            this.entries = entries;
            this.id =  String.valueOf(id);

        } else {
            this.success = false;
        }


    }
}
