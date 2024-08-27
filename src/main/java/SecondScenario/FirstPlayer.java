package SecondScenario;

import java.io.*;
import java.net.Socket; // used this for networking purposes

// So the below FirstPlayer class represents a player that runs as a client in a separate process.
// Meanwhile, connect to a SecondPlayer(ServerPlayer) and also handle the communication.

public class FirstPlayer {

    // Address to connect to the server (Therefore localhost means within the same machine).
    private static final String SERVER_HOST = "localhost";

    // Here we connect to the server (which is the same as the port number of the server).
    private static final int PORT = 12345;

    // Naming of the client.
    private String name = "Client";

    // Now here is a method to start the client.
    public void start() {
        try (Socket socket = new Socket(SERVER_HOST, PORT); // Created a socket that will connect to the server.
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // Reading message from sever.
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) { // It is sending the message to server.

            String receivedMessage; // Created a string.
            while ((receivedMessage = in.readLine()) != null) { // Will Keep reading message from server.
                System.out.println(name + "✅received: " + receivedMessage); // Will Print the received message.
                out.println(receivedMessage + " - 🆗Ack"); // Here we Acknowledge back to the server.
            }
        } catch (IOException e) { // It Handles the IOException (means input/output exceptions).
            e.printStackTrace(); // Print the exception (means error details).
        }

        System.out.println(name + " finished."); // Print when the client finished its process.
    }

    // Main method for client.
    public static void main(String[] args) {
        new FirstPlayer().start(); // FirstPlayer instance initialized and started. 
    }
}
