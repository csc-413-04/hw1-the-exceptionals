package simpleserver;

public class ProcessorFactory {

	//processType would either be users or posts
	//With args you can process: Users: returns all users or returns user by ID
	//Posts: returns post by ID or returns post by ID & limits to certain length
	public Processor ProcessorFactory(String[] args, String processType) {
		switch(processType) {
			case "/users":
				return new UserProcessor(args[2]);
			break;

			case "/posts":
				return new PostProcessor(args);
			break;
		}
		return null;
	}

}


