package simpleserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ProcessorFactory {

	//processType would either be users or posts
	//With args you can process: Users: returns all users or returns user by ID
	//Posts: returns post by ID or returns post by ID & limits to certain length
	static Processor getProcessor(String url) {
		//String endpoint = "/users";
		String endpoint;
		String query;
		Processor processor = null;
		boolean check = false;
        char [] c = url.toCharArray();
        for (char i : c){
          if (i == '?') {
            check = true;
          }
        }
        if(check==true) {
			String[] requestParts = url.split("\\?");
			endpoint = requestParts[0];
		}
		else {
			endpoint = url;
		}




		switch(endpoint) {
			case "/user":
				processor = new UserProcessor();
				return processor;
			//break;

			case "/posts":
				processor = new PostProcessor();
				return processor;
			//break;
			default:
				return new ErrorProcessor();

		}
	}


}


