// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 
package client;

import ocsf.client.*;
import common.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class overrides some of the methods defined in the abstract superclass in order to give more functionality to the client.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;
 * @author Fran&ccedil;ois B&eacute;langer
 * @version July 2000
 */
public class ChatClient extends AbstractClient {
    //Instance variables **********************************************

    /**
     * The interface type variable. It allows the implementation of the display method in the client.
     */
    ChatIF clientUI;
    String id;//login id, added for E51

    //Constructors ****************************************************
    /**
     * Constructs an instance of the chat client.
     *
     * @param host The server to connect to.
     * @param port The port number to connect on.
     * @param clientUI The interface type variable.
     */
    public ChatClient(String ID, String host, int port, ChatIF clientUI) //changed for E51
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
    public void handleMessageFromServer(Object msg) {
        switch (msg.toString()) {
            case "#1":
                clientUI.receiveCommand("#1");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#2":
                clientUI.receiveCommand("#2");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#3":
                clientUI.receiveCommand("#3");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#4":
                clientUI.receiveCommand("#4");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#5":
                clientUI.receiveCommand("#5");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#6":
                clientUI.receiveCommand("#6");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#7":
                clientUI.receiveCommand("#7");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#8":
                clientUI.receiveCommand("#8");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#9":
                clientUI.receiveCommand("#9");
                clientUI.receiveCommand("#clientTurn");
                break;
            case "#serverWon":
                clientUI.receiveCommand("disableAll");    
                clientUI.receiveCommand("#serverWon");
                break;
            case "#clientWon":
                clientUI.receiveCommand("disableAll");
                clientUI.receiveCommand("#clientWon");
                break;
            case "#draw":
                clientUI.receiveCommand("disableAll");
                clientUI.receiveCommand("#draw");
                break;
            default:
                break;
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
                handleCommand(message);//added for E50
            } catch (IOException ex) {
                Logger.getLogger(ChatClient.class.getName()).log(Level.SEVERE, null, ex);
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

    public void handleCommand(String command) throws IOException {//added for E50
        if (command.equals("#quit")) {
            quit();
        } else if (command.equals("#logoff")) {
            try {
                closeConnection();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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

    protected void connectionClosed() { //added for E49a
        System.out.println("Connection closed");
    }

    protected void connectionException(Exception exception) { //added for E49a
        connectionClosed();
        System.out.println("Server has shutted down.");
        System.out.println("Terminating client...");
        System.exit(1);
    }

    @Override
    protected void connectionEstablished() {
        Thread t = new Thread(new Runnable() {
            public void run() {
                clientUI.receiveCommand("enableAll");
            }
        }, "EnableButton");
        t.start();
    }
}
