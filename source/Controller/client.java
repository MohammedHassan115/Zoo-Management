package m;

import java.io.*;
import java.net.*;
import java.util.*;

// Client class
class client {

    public client() {
        // establish a connection by providing host and port
        // number
        try (Socket socket = new Socket("localhost", 6534)) {

            // writing to server
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // reading from server
            BufferedReader in= new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // object of scanner class
            Scanner sc = new Scanner(System.in);
            String line = null;

            while (!"exit".equalsIgnoreCase(line)) {

                System.out.println("Which one to find it in server:\n* animal\n* employee\n* supply");
                // reading from user
                line = sc.nextLine();

                // sending the user input to server
                out.println(line);
                out.flush();

                // displaying server reply
                System.out.println("Server replied "+ in.readLine());
            }

            // closing the scanner object
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
