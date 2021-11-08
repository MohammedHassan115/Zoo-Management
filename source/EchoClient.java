package m;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws IOException {
		client();
	}
	public static void client() throws IOException {
		Scanner s = new Scanner(System.in);
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			echoSocket = new Socket("127.0.0.1", 6666);
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in=new BufferedReader(new InputStreamReader( echoSocket. getInputStream()));
			} catch (UnknownHostException e) {
			System.err.println("Don't know host: toshiba.");
			System.exit(1);
			} catch (IOException e) {
			System.err.println("Couldn't get I/O for " + "the connection to: toshiba.");
			System.exit(1);
			}
		    System.out.println("please choose one of them to find it in server:\n* animal\n* employee\n* supply");
		    String choose = s.nextLine().toLowerCase();
		    String fileName = router.r(choose);
			File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\" + fileName);
			BufferedReader br = new BufferedReader(new FileReader(f));
			BufferedReader stdIn = new BufferedReader(br);
			String userInput;
			System.out.println(in.readLine());
			while ((userInput = stdIn.readLine()) != null) {
			out.println(userInput);
			System.out.println("echo: " + in.readLine());
			}
			out.close();
			in.close();
			stdIn.close();
			echoSocket.close();
	}

}
class router{
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
}	
