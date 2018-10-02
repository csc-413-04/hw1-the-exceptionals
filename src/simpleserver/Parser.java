package simpleserver;
import java.io.*;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.lang.*;
import java.util.Map.Entry;


public class Parser extends Database {
    public Parser() throws FileNotFoundException, UnsupportedEncodingException {
        super();
        // Part2:
        // Parsing the input. Input ex: /user?userid=1
        // output should be like endpoints-users, and args if any. Key-value pairs of string string. Can be an array of them
        // hash_map<String, String>
        // output example: /user and key-value pair like <userid: 1>

        Database storage = new Database();
        HashMap<String, User> hmUserInput = storage.userHashMap;
        HashMap<String, Posts> hmPostsInput = storage.postsHashMap;

        // HashMap for output
        HashMap<String[], String[]> hmUserOutput = new HashMap<String[], String[]>();
        HashMap<String[], String[]> hmPostsOutput = new HashMap<String[], String[]>();


        // receive input from Database userHashMap and postsHashMap <String, Object>
        // Parse the input into a hash_map<String, String>
        String[] parsingInput, parsingInputTwo;
        String[] splitUserId;
        String key, value, parsingInputFirst, parsingInputSecond, parsingSecondFirst, parsingSecondSecond;
        boolean boolToCheckForParam = false;
        boolean boolToCheckForArgs = false;
        String valueForOutput;

        // Loop for User
        for (Map.Entry m : hmUserInput.entrySet()) {

            key = String.valueOf(m.getKey());
            value = String.valueOf(m.getValue());

            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '?') {
                    boolToCheckForParam = true;
                }
            }
            if (boolToCheckForParam == true) {
                parsingInput = value.split("\\?");
                key = parsingInput[0];
                //key = key + ": ";
                value = parsingInput[1];
                splitUserId = value.split("\\=");
                value = splitUserId[1];
                hmUserOutput.put(new String[]{"userid: ", "username: "}, new String[]{value, key});
            }
            else {
                hmUserOutput.put(new String[]{"username: "}, new String[]{key});
            }


        }

        // Loop for Posts
        boolToCheckForArgs=false;
        for (Map.Entry m : hmPostsInput.entrySet()) {

            key = String.valueOf(m.getKey());
            value = String.valueOf(m.getValue());

            for (int i = 0; i < value.length(); i++) {
                if (value.charAt(i) == '&') {
                    boolToCheckForArgs = true;
                }
                parsingInput = value.split("\\?");
                parsingInputFirst = parsingInput[0]; //parsingInputFirst= userid
                parsingInputSecond = parsingInput[1];
                if (boolToCheckForArgs == true) {
                    parsingInputTwo = parsingInputSecond.split("\\&");
                    parsingSecondFirst = parsingInputTwo[0];//parsingSecondFirst= postid
                    parsingSecondSecond = parsingInputTwo[1];//parsingSecondSecond = maxlength
                    hmPostsOutput.put(new String[]{"userid: ", "postid: ", "data: "}, new String[]{parsingInputFirst, parsingSecondFirst, parsingSecondSecond});
                }
                else {
                    hmPostsOutput.put(new String[]{"userid: ", "postid: "}, new String[]{parsingInputFirst, parsingInputSecond});
                }
            }
        }
    }
}

