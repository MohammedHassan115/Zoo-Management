package m;

import java.io.*;
import java.net.*;
import java.util.*;


// Client class
class client {
	
	public client() {
		// establish a connection by providing host and port
		// number
		try (Socket socket = new Socket("localhost", 1234)) {
					
			// writing to server
		PrintWriter out = new PrintWriter(
		socket.getOutputStream(), true);

		// reading from server
		BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

		Scanner sc = new Scanner(System.in);
		String line = null;

		while (!"exit".equalsIgnoreCase(line)) {
						
		System.out.println("Which one to find it in server:\n* animals\n* employees\n* supplies");
		// reading from user
		line = sc.nextLine();

		if(line.equals("animals") || line.equals("employees") || line.equals("supplies")) {
			out.println(line);
			out.flush();
			System.out.println("Server replied: "+ in.readLine() + "\n");
		}else {
			System.out.println("Please select one of the choose from the list\n");
		}
		
		}
					
		sc.close();
		}
		catch (IOException e) {
		e.printStackTrace();
			}
	}
	// driver code
	public static void main(String[] args)
	{
		new client();
	}
}
