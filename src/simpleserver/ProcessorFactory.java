package simpleserver;

public class ProcessorFactory {

	// processType would either be users or posts
	// With args you can process: Users: returns all users or returns user by ID
	// Posts: returns post by ID or returns post by ID & limits to certain length
	public static Processor makeProcessor(String processType) {
		switch (processType) {
		case "/user?userid":
			return new UserProcessor();
		case "/users":
			return new UserProcessor();
		case "/posts":
			return new PostProcessor();
		}
		return null;
	}

	/*
	 * static ServerProcessor getProcessor(String endpoint){
	 * 
	 * }
	 */

}
