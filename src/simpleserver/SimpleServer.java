package simpleserver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class SimpleServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ding;
		Socket dong = null;
		String resource = null;
		String mainline = null;
		try {
			ding = new ServerSocket(1299);
			System.out.println("Opened socket " + 1299);
			while (true) {

				// keeps listening for new clients, one at a time
				try {
					dong = ding.accept(); // waits for client here
				} catch (IOException e) {
					System.out.println("Error opening socket");
					System.exit(1);
				}

				InputStream stream = dong.getInputStream();
				BufferedReader in = new BufferedReader(new InputStreamReader(stream));
				try {

					// read the first line to get the request method, URI and HTTP version
					String line = in.readLine();
					mainline = line;
					System.out.println("----------REQUEST START---------");
					System.out.println(line);
					// read only headers
					line = in.readLine();
					while (line != null && line.trim().length() > 0) {
						int index = line.indexOf(": ");
						if (index > 0) {
							System.out.println(line);
						} else {
							break;
						}
						line = in.readLine();
					}
					System.out.println("----------REQUEST END---------\n\n");
				} catch (IOException e) {
					System.out.println("Error reading");
					System.exit(1);
				}

				BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
				PrintWriter writer = new PrintWriter(out, true); // char output to the client

				// every response will always have the status-line, date, and server name
				writer.println("HTTP/1.1 200 OK");
				writer.println("Server: TEST");
				writer.println("Connection: close");
				writer.println("Content-type: text/html");
				writer.println("");

				String[] requests = mainline.split(" ");
				String[] endpoint = requests[1].split("=");
				Processor processor = ProcessorFactory.makeProcessor(endpoint[0]);
				String response = processor.process(endpoint);
				writer.println(response);
				// Part1: Database object. Read in json from dummy data and make a hash_map
				// <String, String>. Index the data by user.

				// Part2:
				// Parsing the input. Input ex: /user?/userid=1
				// output should be like endpoints-users, and args if any. Key-value pairs of
				// string string. Can be an array of them
				// hash_map<String, String>
				// output example: /user <userid: 1>

				// Part3:
				// (Factory) Business logic. Deciding what to respond. Processor class.(Picking
				// between user and post). Lastly, output.

				// Body of our response

				dong.close();
			}
		} catch (IOException e) {
			System.out.println("Error opening socket");
			System.exit(1);
		}
	}
}
