package pop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class serverSocket {
	public static void main(String args[]) throws IOException {
		ServerSocket serverSocket = null;
		try {
		serverSocket = new ServerSocket(8188);
		} catch (IOException e) {
		System.err.println("Could not listen on port: 5432.");
		System.exit(1);
		}
		Socket clientSocket = null;
		try {
		clientSocket = serverSocket.accept();
		} catch (IOException e) {
		System.err.println("Accept failed.");
		System.exit(1);
		}
		PrintWriter out = new PrintWriter(
		clientSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader( new
		InputStreamReader(clientSocket.getInputStream()));
		String outputLine = "";
		String inputLine = "";
		while ((inputLine = in.readLine()) != null) {
		outputLine = inputLine;
		FileWriter fw = new FileWriter(outputLine + ".txt", true);
		File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\" + outputLine + ".txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		BufferedReader stdIn = new BufferedReader(br);
		String st;
		String ff = "";
		while((st = br.readLine()) != null){
			System.out.println(st);
			ff += st;
		}
		out.println(ff);	
	}
	out.close();
	in.close();
	clientSocket.close();
	serverSocket.close();	
}
}
/*class router{
	static String FN = "";
	public static String r(String c) {
		switch(c){
		case "animal":
		FN = "animal.txt";
			break;
		case "employee":
			FN = "employee.txt";	
			break;
		case "supply":
			FN = "supply.txt";
			break;
		default:
			break;
	}
		return FN;
}
}*/	
