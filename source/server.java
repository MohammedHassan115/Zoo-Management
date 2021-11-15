package pop;

import java.io.*;
import java.net.*;

// Server class
class server {
	public static void main(String[] args)
	{
		ServerSocket server = null;

		try {

			// server is listening on port 1234
			server = new ServerSocket(6534);
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
				// separately
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
					FileWriter fw = new FileWriter(line + ".txt", true);
			    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\" + line + ".txt");
					BufferedReader br = new BufferedReader(new FileReader(f));
					String st;
					String ff = "";
					while((st = br.readLine()) != null){
						ff += st;
					}
					out.println(ff);
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

/*FileWriter fw = new FileWriter(line + ".txt", true);	
			    	File f = new File("C:\\Users\\PC-BALEN\\eclipse-workspace\\mom\\" + line + ".txt");
					BufferedReader br = new BufferedReader(new FileReader(f));
					String st;
					String ff = "";
					while((st = br.readLine()) != null){
						ff += st;
					}*/