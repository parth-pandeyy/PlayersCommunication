package FirstScenario;

import java.util.concurrent.atomic.AtomicInteger; // Using AtomicInteger here for atomically incrementing counter for the message count.

// So the below Player class implements runnable for instance, so that it can run as threads. Meanwhile it will help communicates with another player instance.

public class Player implements Runnable {
    private static final int MAX_MESSAGES = 10; // Maximum messages can be exchanged.
    private String name; // created an string. (either "initiator" or just opposite means "responder").
    private Player otherPlayer; // reference to the other player.
    private AtomicInteger messageCount = new AtomicInteger(0); // counter which is used as number of messages sent.

    public Player(String name) { // Initializing the player name.
        this.name = name;
    }

    public void setOtherPlayer(Player otherPlayer) { // will work as an reference to the otherPlayer.
        this.otherPlayer = otherPlayer;
    }

    public void receiveMessage(String message) { // This method is going to handle the receiving message.
        int count = messageCount.incrementAndGet(); // Increments the value (it means meassage count).
        String newMessage = message + " - Response " + count; // Add the messageCount to received message.
        System.out.println(name + "✅received: " + message + " | 📨Sending: " + newMessage); // Print the received message and the newMessage.
        if (count < MAX_MESSAGES) { // if count is less than MAX_MESSAGES.
            otherPlayer.receiveMessage(newMessage); // Send the message to the other player.
        }
    }

    @Override
    public void run() { // Run method for start.
        if ("Initiator".equals(name)) { // If player is Initiator.
            otherPlayer.receiveMessage("🚀Start"); // Initiator start message exchange by sending start message.
        }
    }
}
