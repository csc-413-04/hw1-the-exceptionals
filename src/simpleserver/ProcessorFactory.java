package simpleserver;

public class ProcessorFactory {

	//processType would either be users or posts
	//With args you can process: Users: returns all users or returns user by ID
	//Posts: returns post by ID or returns post by ID & limits to certain length
	public static Processor makeProcessor(String[] args, String processType) {
		switch(processType) {
			case "/users":
				return new UserProcessor(args);
			//break;

			case "/posts":
				return new PostProcessor(args);
			//break;
		}
		return null;
	}

	/*
	static ServerProcessor getProcessor(String endpoint){

	}*/

}


