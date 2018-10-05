package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class UserProcessor extends Processor {

    int entries = 0;
    ArrayList<String> userList;


	public UserProcessor(String[] args) {
        try {
            Parser parser = new Parser();
            userList = parser.getUser();
        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding exception");
        }

        if(Integer.parseInt(args[0]) == -1) {
            entries = userList.size();
            id = "-1";
        }

	    if(Integer.parseInt(args[0]) > 0 && userList != null) {
	        id = args[0];
		}
	}

	@Override
    public String process(ArrayList<String> processUser) {
	    System.out.println("Username: "+(processUser.get(Integer.parseInt(id)-1)+" user ID: "+(Integer.parseInt(id)-1)));

	    UserResponse userResponse = new UserResponse(processUser, entries, Integer.parseInt(id));
	    userResponse.response();
	    return "Username: "+(processUser.get(Integer.parseInt(id)-1)+" user ID: "+(Integer.parseInt(id)-1));
    }

/*	@Override
	public String process(User user) {

		if(user == null) {
			return "Error: Null user";
		}
		this.type = "User";
		this.id = String.valueOf(user.getUserID());
		System.out.println("User id: "+user.getUserID()+" Username: "+user.getUsername());
		return "User id: "+user.getUserID()+" Username: "+user.getUsername();
	}*/


/*	public String[] processAll(JsonArray userArray) {
		String[] stringArray = new String[userArray.size()];
		for(int i = 0; i < userArray.size(); i++) {
			stringArray[i] = userArray.get(i).getAsString();
		}
		return stringArray;
	}*/
}
