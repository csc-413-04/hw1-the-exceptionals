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
        }
    public static ArrayList getUser () {
        ArrayList<String> alUserOutput = new ArrayList<>();
        String name,nameOutput;
        for (User m : userArrayList) {
            name = String.valueOf(m.getUsername());
            nameOutput = new StringBuilder().append("username: ").append(name).toString();
            if (name != "Error") {
                alUserOutput.add(nameOutput);
            } else alUserOutput.add("Error");
        }
        return alUserOutput;
    }
    public static ArrayList getUserbyId() {
        ArrayList<String[]> alUserOutput = new ArrayList<>();
        String name, UserIdString, nameOutput, userIdStringOutput;
        int userId;

        for (User m : userArrayList) {
            name = m.getUsername();
            userId = m.getUserID();
            UserIdString = String.valueOf(userId);
            if (name != "Error") {
                nameOutput = new StringBuilder().append("username: ").append(name).toString();
                userIdStringOutput = new StringBuilder().append("userid: ").append(UserIdString).toString();

                String[] arg1 = {userIdStringOutput,nameOutput};
                alUserOutput.add(arg1);
            } else {
                String[] arg2 = {"Error"};
                alUserOutput.add(arg2);
            }
        }
        return alUserOutput;
    }
    public static ArrayList getPostsById() {
        ArrayList<String[]> alPostsOutput = new ArrayList<>();
        String userIdString, postsIdString, userIdStringOutput, postsIdStringOutput;
        int userId, postsId;
        for (Posts m : postsArrayList) {
            postsId = m.getPostID();
            userId = m.getUserId();
            postsIdString = String.valueOf(postsId);
            userIdString = String.valueOf(userId);
            if (userId != -1) {
                userIdStringOutput = new StringBuilder().append("userid: ").append(userIdString).toString();
                postsIdStringOutput = new StringBuilder().append("postid: ").append(postsIdString).toString();


                String[] arg1 = {postsIdStringOutput, userIdStringOutput};
                alPostsOutput.add(arg1);
            } else {
                String[] arg2 = {"Error"};
                alPostsOutput.add(arg2);
            }
        }
        return alPostsOutput;
    }
    public static ArrayList getPostsByLength() {
        ArrayList<String[]> alPostsOutput = new ArrayList<>();
        String content, userIdString, postsIdString, userIdStringOutput, postsIdStringOutput, contentOutput;
        int userId, postsId;
        for (Posts m : postsArrayList) {
            postsId = m.getPostID();
            userId = m.getUserId();
            content = m.getPostContent();
            postsIdString = String.valueOf(postsId);
            userIdString = String.valueOf(userId);
            if (userIdString != "-1") {
                userIdStringOutput = new StringBuilder().append("userid: ").append(userIdString).toString();
                postsIdStringOutput = new StringBuilder().append("postid: ").append(postsIdString).toString();
                contentOutput = new StringBuilder().append("data: ").append(content).toString();
                String[] arg1 = {postsIdStringOutput, userIdStringOutput, contentOutput};
                alPostsOutput.add(arg1);
            } else {
                String[] arg2 = {"Error"};
                alPostsOutput.add(arg2);
            }
        }
        return alPostsOutput;
    }
}

