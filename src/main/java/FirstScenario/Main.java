package FirstScenario;

// Main Class
public class Main {
    public static void main(String[] args) { // Main method.
        Player player1 = new Player("Initiator"); // create a player1, will start the communication.
        Player player2 = new Player("Responder"); // create a player2, will respond to the message received as initiator.

        player1.setOtherPlayer(player2); // responder to otherplayer for initiator.
        player2.setOtherPlayer(player1); // initiator to otherplayer for responder.

        Thread t1 = new Thread(player1); // Thread for FirsPlayer(act as initiator).
        Thread t2 = new Thread(player2); // Thread for SecondPlayer(act as responder).

        t1.start(); // Initiator thread starts.
        t2.start(); // Responder thread starts.

        try {
            t1.join(); // Let Initiator thread finish.
            t2.join(); // Let Responder thread finish.
        } catch (InterruptedException e) { // It Handles the interruption.
            e.printStackTrace(); // Print the stack trace (means error details, it will help us to debug).
        }

        System.out.println("Program finished Thank You 🎉✨."); // Program has finished.
    }
}
