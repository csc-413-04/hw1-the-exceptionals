package simpleserver;

public abstract class Response {
	boolean success; // status
	int entries;
	String id;

    //Constructor for creating new responses
	public abstract void response();


}