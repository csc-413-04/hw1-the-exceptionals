package simpleserver;

public class ProcessorFactory {

	public Processor ProcessorFactory(String[] args, String type) {
		switch(type) {
			case "/users":
				return new UserProcessor();

			case "/posts":
				return new PostProcessor();
		}
		return null;
	}

}


