package simpleserver;

import java.util.ArrayList;

public abstract class Processor {
	String id;
	String type;
	//public abstract String process();
	abstract String process(ArrayList<String> list);
	//abstract String process(User user);
}
