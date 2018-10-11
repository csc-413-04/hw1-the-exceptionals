package simpleserver;

import java.util.ArrayList;

public abstract class Processor {
	String id;
	String type;
	Database db = null;
	String[] endpoint = null;

	// public abstract String process();
	abstract String process(String[] ep);
	// abstract String process(User user);
}
