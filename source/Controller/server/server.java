package pop;


import java.io.*;
import java.net.*;
import java.sql.*;
import java.util.ArrayList;

// Server class
class server {
	static String url = "jdbc:mysql://localhost:3306/zoo";
	static String uname = "root";
	static String password = "12345";
	// static String query = "";
	static Connection con = null;
	public static void main(String[] args)
	{
		ServerSocket server = null;

		try {

			// server is listening on port 1234
			server = new ServerSocket(1234);
			server.setReuseAddress(true);

			// running infinite loop for getting
			// client request
			while (true) {

				// socket object to receive incoming client
				// requests
				Socket client = server.accept();

				// Displaying that new client is connected
				// to server
				System.out.println("New client connected"
								+ client.getInetAddress()
										.getHostAddress());

				// create a new thread object
				ClientHandler clientSock
					= new ClientHandler(client);

				// This thread will handle the client
				new Thread(clientSock).start();
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (server != null) {
				try {
					server.close();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// ClientHandler class
	private static class ClientHandler implements Runnable {
		private final Socket clientSocket;

		// Constructor
		public ClientHandler(Socket socket)
		{
			this.clientSocket = socket;
		}

		public void run()
		{
			PrintWriter out = null;
			BufferedReader in = null;
			try {
					
				// get the outputstream of client
				out = new PrintWriter(
					clientSocket.getOutputStream(), true);

				// get the inputstream of client
				in = new BufferedReader(
					new InputStreamReader(
						clientSocket.getInputStream()));

				String line;
				while ((line = in.readLine()) != null) {

					
					// writing the received message from
					// client
					System.out.printf("Sent from the client: %s\n",line);
					if(line.equals("supplies")) {
					String query = String.format("select * from %s", line);
						try {
							con = DriverManager.getConnection(url, uname, password);
							Statement statement = con.createStatement();
							ResultSet result = statement.executeQuery(query);
							ArrayList<String> arraylist = new ArrayList<String>();
							while(result.next()) {
								String names  = result.getString("names");
								String quantity  = result.getString("quantities");
								String price  = result.getString("prices");
								 arraylist.add(names + ": " + quantity + ": " + price);
							}
							statement.close();
							con.close();
							out.println(arraylist);
						}catch(SQLException e) {
							e.printStackTrace();
						}
				    	System.out.println();
					}else {
					   String query = String.format("select * from %s", line);	
					   try {
					   con = DriverManager.getConnection(url, uname, password);
					   Statement statement = con.createStatement();
					   ResultSet result = statement.executeQuery(query);
					   ArrayList<String> arraylist = new ArrayList<String>();
					   while(result.next()) {
						 String names  = result.getString("names");
						 String informations  = result.getString("information");
						 arraylist.add(names + ": " + informations);
						}
					   statement.close();
					   con.close();
					   out.println(arraylist);
					}catch(SQLException e) {
						e.printStackTrace();
					}
			    	System.out.println();
					}
					
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (out != null) {
						out.close();
					}
					if (in != null) {
						in.close();
						clientSocket.close();
					}
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
