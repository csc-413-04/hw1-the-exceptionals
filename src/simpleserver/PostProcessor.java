package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PostProcessor extends Processor {
    ArrayList<String> postList;
	public PostProcessor(String[] args) {
        try {
            Parser parser = new Parser();
            //postList = parser.getPostbyID();
        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding exception");
        }
    }
    public String process() {
	    return "";
    }
	public String process(ArrayList<String> postList) {
		return "";
	}
}
