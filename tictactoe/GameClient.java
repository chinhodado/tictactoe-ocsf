// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import ocsf.client.*;
import common.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class overrides some of the methods defined in the abstract superclass
 * in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class GameClient extends AbstractClient {
    //Instance variables **********************************************

    /**
     * The interface type variable. It allows the implementation of the display
     * method in the client.
     */
    GameIF clientUI;
    String id;

    //Constructors ****************************************************
    /**
     * Constructs an instance of the game client.
     *
     * @param host The server to connect to.
     * @param port The port number to connect on.
     * @param clientUI The interface type variable.
     */
    public GameClient(String ID, String host, int port, GameIF clientUI)
            throws IOException {
        super(host, port); //Call the superclass constructor
        this.id = ID;
        this.clientUI = clientUI;
        try {
            openConnection();
        } catch (IOException e) {
            System.out.println("Error: Can't setup connection! Awaiting command");
            return;
        }
        try {
            sendToServer("#login " + id);
        } catch (IOException e) {
            clientUI.display("An error occurred.  Terminating client.");
            quit();
        }
    }

    //Instance methods ************************************************
    /**
     * This method handles all data that comes in from the server.
     *
     * @param msg The message from the server.
     */
    @Override
    public void handleMessageFromServer(Object msg) {
        if (msg.toString().contains("#list")) {
            clientUI.receiveCommand(msg.toString());
        } else {
            switch (msg.toString()) {
                case "#XX1":
                    clientUI.receiveCommand("#XX1");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX2":
                    clientUI.receiveCommand("#XX2");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX3":
                    clientUI.receiveCommand("#XX3");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX4":
                    clientUI.receiveCommand("#XX4");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX5":
                    clientUI.receiveCommand("#XX5");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX6":
                    clientUI.receiveCommand("#XX6");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX7":
                    clientUI.receiveCommand("#XX7");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX8":
                    clientUI.receiveCommand("#XX8");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#XX9":
                    clientUI.receiveCommand("#XX9");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO1":
                    clientUI.receiveCommand("#OO1");
                    clientUI.receiveCommand("#clientTurn");
                    break;

                case "#OO2":
                    clientUI.receiveCommand("#OO2");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO3":
                    clientUI.receiveCommand("#OO3");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO4":
                    clientUI.receiveCommand("#OO4");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO5":
                    clientUI.receiveCommand("#OO5");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO6":
                    clientUI.receiveCommand("#OO6");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO7":
                    clientUI.receiveCommand("#OO7");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO8":
                    clientUI.receiveCommand("#OO8");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#OO9":
                    clientUI.receiveCommand("#OO9");
                    clientUI.receiveCommand("#clientTurn");
                    break;
                case "#clientLost":
                    clientUI.receiveCommand("disableAll");
                    clientUI.receiveCommand("#clientLost");
                    break;
                case "#clientWon":
                    clientUI.receiveCommand("disableAll");
                    clientUI.receiveCommand("#clientWon");
                    break;
                case "#draw":
                    clientUI.receiveCommand("disableAll");
                    clientUI.receiveCommand("#draw");
                    break;
                case "#restart":
                    clientUI.receiveCommand("#restart");
                case "#gameStart":
                    clientUI.receiveCommand("enableAll");
                case "#clientFirst":
                    clientUI.receiveCommand("#clientFirst");
                default:
                    break;
            }
        }
        clientUI.display(msg.toString());
    }

    /**
     * This method handles all data coming from the UI
     *
     * @param message The message from the UI.
     */
    public void handleMessageFromClientUI(String message) {
        char temp = message.charAt(0);
        if (temp == '#') {
            try {
                handleCommand(message);
            } catch (IOException ex) {
                Logger.getLogger(GameClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                sendToServer(message);
            } catch (IOException e) {
                clientUI.display("Could not send message to server.  Terminating client.");
                quit();
            }
        }
    }

    public void handleCommand(String command) throws IOException {
        if (command.equals("#quit")) {
            quit();
        } else if (command.equals("#logoff")) {
            try {
                closeConnection();
            } catch (IOException e) {
            }
        } else if (command.contains("#sethost")) {
            if (!isConnected()) {
                String newHost = command.substring(9);
                setHost(newHost);
                System.out.println("Changed host to " + newHost);
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.contains("#setport")) {
            if (!isConnected()) {
                int newPort = Integer.parseInt(command.substring(9));
                setPort(newPort);
                System.out.println("Changed port to " + newPort);
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.contains("#login")) {
            if (!isConnected()) {
                try {
                    openConnection();
                    sendToServer(command);
                    System.out.println("Connected to server!");
                } catch (IOException e) {
                }
            } else {
                System.out.println("Already connected!");
            }
        } else if (command.equals("#gethost")) {
            System.out.println("Host: " + getHost());
        } else if (command.equals("#getport")) {
            System.out.println("Port: " + getPort());
        } else if (command.equals("#1")) {
            sendToServer("#1");
        } else if (command.equals("#2")) {
            sendToServer("#2");
        } else if (command.equals("#3")) {
            sendToServer("#3");
        } else if (command.equals("#4")) {
            sendToServer("#4");
        } else if (command.equals("#5")) {
            sendToServer("#5");
        } else if (command.equals("#6")) {
            sendToServer("#6");
        } else if (command.equals("#7")) {
            sendToServer("#7");
        } else if (command.equals("#8")) {
            sendToServer("#8");
        } else if (command.equals("#9")) {
            sendToServer("#9");
        } else if (command.equals("#createGame")) {
            sendToServer("#createGame");
        } else if (command.equals("#getGameList")) {
            sendToServer("#getGameList");
        } else {
            System.out.println("Command not recognized!");
        }
    }

    /**
     * This method terminates the client.
     */
    public void quit() {
        try {
            closeConnection();
        } catch (IOException e) {
        }
        System.exit(0);
    }

    @Override
    protected void connectionClosed() {
        System.out.println("Connection closed");
    }

    @Override
    protected void connectionException(Exception exception) {
        connectionClosed();
        System.out.println("Server has shutted down.");
        System.out.println("Terminating client...");
        System.exit(1);
    }

    @Override
    protected void connectionEstablished() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                clientUI.receiveCommand("#connected");
            }
        }, "EnableButton");
        t.start();
    }
}
