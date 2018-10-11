package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PostProcessor extends Processor {
	private int postLength;
	private ArrayList<String> postList;

	public PostProcessor() {
		try {
			Database db = new Database();
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String process(String[] ep) {
		PostResponse ur = new PostResponse(db, ep);
		return ur.response();
	}
}
