// This file contains material supporting section 3.7 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

import java.io.*;
import common.GameIF;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import ocsf.server.*;

/**
 * This class overrides some of the methods in the abstract superclass in order
 * to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class GameServer extends AbstractServer {
    //Class variables *************************************************

    /**
     * The default port to listen on.
     */
    final public static int DEFAULT_PORT = 5555;
    GameIF serverUI;//the server console
    boolean closed = false;//sever closed?
    boolean stopped = false;//server stopped?
    Hashtable gameTable = new Hashtable();
    ArrayList<Game> gameList = new ArrayList();
    static int gameName = 100;
    //game class

//    public static class Game {
//
//        String name;
//        ConnectionToClient playerX;
//        ConnectionToClient playerO;
//
//        public Game(int name) {
//            this.name = name + "";
//        }
//
//        public void addPlayer(ConnectionToClient player) {
//            if (playerX == null) {
//                playerX = player;
//            } else if (playerO == null) {
//                playerO = player;
//            }
//        }
//    }
    //Constructors ****************************************************
    /**
     * Constructs an instance of the echo server.
     *
     * @param port The port number to connect on.
     */
    public GameServer(int port, GameIF serverUI) //changed for E50b
    {
        super(port);
        this.serverUI = serverUI;
        try {
            listen(); //Start listening for connections
        } catch (Exception ex) {
            System.out.println("ERROR - Could not listen for clients!");
        }
    }

    //Instance methods ************************************************
    /**
     * This method handles any messages received from the client.
     *
     * @param msg The message received from the client.
     * @param client The connection from which the message originated.
     */
    @Override
    public void handleMessageFromClient(Object msg, ConnectionToClient client) {
        if (client.getInfo("numMess").equals(0)) {
            if (!((String) msg).contains("#login")) {
                try {
                    client.sendToClient("SERVER MSG> Error: No login ID provided!");
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                String id = ((String) msg).substring(7);
                client.setInfo("ID", id);
                client.setInfo("numMess", 1);
                System.out.println("Message received " + msg + " from " + id);
                System.out.println(id + " has logged on");
                try {
                    client.sendToClient(id + " has logged on");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        } else {
            System.out.println("Message received: " + msg + " from " + client + " (" + client.getInfo("ID") + ")");
            this.sendToAllClients(client.getInfo("ID") + ": " + msg);
            client.setInfo("numMess", 1);
            if (msg.toString().contains("#join")) {
                String gameID = msg.toString().substring(6);
                for (Game game : gameList) {
                    if (game.getName().equals(gameID)) {
                        game.addPlayerO(client);
                        final Game game2 = game;
                        Thread t = new Thread(new Runnable() {
                            public void run() {
                                try {
                                    game2.playerO.sendToClient("#gameStart");
                                    game2.playerX.sendToClient("#gameStart");
                                } catch (IOException ex) {
                                    Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
                                }                                
                                //startGame(game2);
                            }
                        }, "startgame");
                        t.start();
                    }
                }
            } else {
                switch (msg.toString()) {
                    case "#1":
                        serverUI.receiveCommand("#1");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#2":
                        serverUI.receiveCommand("#2");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#3":
                        serverUI.receiveCommand("#3");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#4":
                        serverUI.receiveCommand("#4");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#5":
                        serverUI.receiveCommand("#5");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#6":
                        serverUI.receiveCommand("#6");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#7":
                        serverUI.receiveCommand("#7");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#8":
                        serverUI.receiveCommand("#8");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#9":
                        serverUI.receiveCommand("#9");
                        serverUI.receiveCommand("#serverTurn");
                        break;
                    case "#clientFirst":
                        serverUI.receiveCommand("#clientFirst");
                        break;
                    case "#createGame":
                        gameTable.put(gameName, client);
                        Game gameTemp = new Game();
                        gameTemp.addPlayerX(client);
                        gameTemp.setName(gameName + "");
                        gameList.add(gameTemp);
                        serverUI.addGame(gameName, client);
                        gameName++;
                        break;
                    case "#getGameList":
                        try {
                            for (int key = 100; key < 900; key++) {
                                if (gameTable.containsKey(key)) {
                                    String name = gameTable.get(key) + "";
                                    client.sendToClient("#list " + key + " " + name);
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * This method overrides the one in the superclass. Called when the server
     * starts listening for connections.
     */
    protected void serverStarted() {
        System.out.println("Server listening for connections on port " + getPort());
        stopped = false;
        closed = false;
    }

    /**
     * This method overrides the one in the superclass. Called when the server
     * stops listening for connections.
     */
    protected void serverStopped() {
        System.out.println("Server has stopped listening for connections.");
        stopped = true;
    }

    //Class methods ***************************************************
    protected void clientConnected(ConnectionToClient client) {//added for E49c
        System.out.println("Client " + client + " connected!");
        client.setInfo("numMess", 0);
        Thread t = new Thread(new Runnable() {
            public void run() {
                //serverUI.receiveCommand("enableAll");
                serverUI.receiveCommand("#enableRestart");
                serverUI.receiveCommand("#connected");
            }
        }, "EnableButton");
        t.start();
    }

    synchronized protected void clientDisconnected(ConnectionToClient client) {//added for E49c
        System.out.println(client.getInfo("ID") + " disconnected!");
        sendToAllClients(client.getInfo("ID") + " disconnected!");
    }

    synchronized protected void clientException(ConnectionToClient client, Throwable exception) {//added for E49c
        System.out.println(client.getInfo("ID") + " disconnected!");
        sendToAllClients(client.getInfo("ID") + " disconnected!");
        Thread t = new Thread(new Runnable() {
            public void run() {
                serverUI.receiveCommand("disableAll");
            }
        }, "DisableButton");
        t.start();
    }

    void handleMessageFromServerUI(String message) {//added for E50b
        char temp = message.charAt(0);
        if (temp == '#') {
            handleCommand(message);//added for E50
        } else {
            sendToAllClients("SERVER MSG> " + message);
            serverUI.display("SERVER MSG> " + message);
        }
    }

    private void handleCommand(String command) {//added for E50c
        if (command.equals("#quit")) {
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.exit(0);
        } else if (command.equals("#stop")) {
            stopListening();
            System.out.println("Listening stopped");
        } else if (command.equals("#close")) {
            stopListening();
            try {
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Server closed");
        } else if (command.contains("#setport")) {
            if (closed) {
                int newPort = Integer.parseInt(command.substring(9));
                setPort(newPort);
                System.out.println("Changed port to " + newPort);
            } else {
                System.out.println("Server not closed yet!");
            }
        } else if (command.equals("#start")) {
            if (stopped) {
                try {
                    listen(); //Start listening for connections
                } catch (Exception ex) {
                    System.out.println("ERROR - Could not listen for clients!");
                }
            } else {
                System.out.println("Server not stopped yet!");
            }
        } else if (command.equals("#getport")) {
            System.out.println("Port: " + getPort());
        } else if (command.equals("#1")) {
            sendToAllClients("#1");
        } else if (command.equals("#2")) {
            sendToAllClients("#2");
        } else if (command.equals("#3")) {
            sendToAllClients("#3");
        } else if (command.equals("#4")) {
            sendToAllClients("#4");
        } else if (command.equals("#5")) {
            sendToAllClients("#5");
        } else if (command.equals("#6")) {
            sendToAllClients("#6");
        } else if (command.equals("#7")) {
            sendToAllClients("#7");
        } else if (command.equals("#8")) {
            sendToAllClients("#8");
        } else if (command.equals("#9")) {
            sendToAllClients("#9");
        } else {
            System.out.println("Command not recognized!");
        }

    }

    protected void serverClosed() {
        closed = true;
    }

    private void startGame(Game game) {
        try {
            game.playerO.sendToClient("#gameStart");
            game.playerX.sendToClient("#gameStart");
        } catch (IOException ex) {
            Logger.getLogger(GameServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}