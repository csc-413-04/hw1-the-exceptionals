package simpleserver;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class PostProcessor extends Processor {
    int postLength;
    ArrayList<String> postList;


	public PostProcessor(String[] args) {
        try {
            Parser parser = new Parser();
            postList = parser.getPostsById();
        } catch (FileNotFoundException e) {
            System.out.println("File not found error");
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Unsupported encoding exception");
        }

        if(Integer.parseInt(args[0]) > 0 && postList != null) { // get post ID
            id = args[0];
        }

        if(args[1] != null) { // if we are specifying a post length
            postLength = Integer.parseInt(args[1]);
        }



    }
    @Override
	public String process(ArrayList<String> processPost) {

	    PostResponse postRes = new PostResponse(processPost, Integer.parseInt(id), postLength);
	    postRes.response();

		return "";
	}
}
