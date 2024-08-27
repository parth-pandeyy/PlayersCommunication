## Please Run the Command as mentioned Below & Do Follow the Step by Step process to Run the Program:

# Please make sure JDK and Apache Maven is installed before running.

# NOTE: Make sure emojis are supported in your IDE environment; otherwise, <?> will appear. If emojis are not installed, either install them or ignore the question marks (<?>) in the output.

## First Scenario:

# (Step 1)
#!/bin/bash
mvn clean package

# (Step 2)
#This command runs the Main class, which initiates the scenario where both players communicate within the same Java process using threads.
java -cp target/PlayersCommunication-1.0-SNAPSHOT.jar FirstScenario.Main



## Second Scenario(It is opposite to 5 as mentioned in the task):

# (Step 1)
#!/bin/bash
mvn clean package

# Now first start the SecondPlayer(ServerPlayer) in terminal because The it act as a PlayerServer which needs to be running and listening for incoming connections before the FirstPlayer(ClientPlayer) attempts to connect. Therefore, If you start the FirstPlayer(clientPlayer) first, then it will try to connect to a SecondPlayer(ServerPlayer) that isn’t yet available, which could result in a connection failure.

# (Step 2)
# Start the Second player in a separate process
java -cp target/PlayersCommunication-1.0-SNAPSHOT.jar SecondScenario.SecondPlayer

# Now, In a new PowerShell window or Split the terminal and run the script:

# (Step 3)
# Start the First player in a separate process
java -cp target/PlayersCommunication-1.0-SNAPSHOT.jar SecondScenario.FirstPlayer



## Hope you like to run and i have also tried to explain each every line in code, so that you can understand clearly what is going on.
