package simpleserver;

public abstract class Processor {
	String id;
	String type;
	//public abstract String process();
	abstract String process(User user);
}
