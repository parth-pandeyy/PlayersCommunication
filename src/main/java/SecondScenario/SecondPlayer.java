package SecondScenario;

import java.io.*;
import java.net.ServerSocket; // used this for networking purposes
import java.net.Socket; // used this for networking purposes

// So the below SecondPlayer class represents a player that runs as a server in an separate process.
// Meanwhile, it represents a player that listen the incoming connection from another player and handles messages(or you can say communication).

public class SecondPlayer {

    // It represent the port number where the server is listening for connection.
    private static final int PORT = 12345;

    // Here it exchange messages(communication), before it got stopped.
    private static final int MAX_MESSAGES = 10;

    // Naming of the server.
    private String name = "Server";

    // It will track the number of count messages sent.
    private int messageCount = 0;

    // Now here is a method to start the server.
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { // Created a server socket that will listen to the specified(or you can say particular) port.
            System.out.println(name + " is waiting⌚ for client connection...");
            try (Socket clientSocket = serverSocket.accept(); // waiting for client connection.
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // reading from the ClientSocket.
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) { // It is sending the message to Client.

                System.out.println(name + " connected to client.");
                out.println("Start"); // Here we start sending the inital message to the client.

                String receivedMessage; // Created a string.
                while ((receivedMessage = in.readLine()) != null && messageCount < MAX_MESSAGES) { // will Keep reading message until it reached the limit.
                    messageCount++; // Increment the message count.
                    String newMessage = receivedMessage + " - Response " + messageCount; // Add the messageCount to receivedMessage.
                    System.out.println(name + "✅received: " + receivedMessage + " | 📨Sending: " + newMessage); // Print the received message and the newMessage.
                    out.println(newMessage); // newMessage back to the Client.
                }
            }
        } catch (IOException e) { // It Handles the IOException (means input/output exceptions).
            e.printStackTrace(); // Print the exception (means error details).
        }

        System.out.println(name + " finished."); // Print when the server finished.
    }

    // Main method for server.
    public static void main(String[] args) {
        new SecondPlayer().start(); // SecondPlayer instance initialized and started. 
    }
}
