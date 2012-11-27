
import java.io.*;
import common.*;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import ocsf.server.ConnectionToClient;

public class GameServerGUI extends javax.swing.JFrame implements GameIF {

    GameServer server;
    static GameServerGUI gameServ;
    static int count = 0;
    public boolean clientFirst = false;
    DefaultListModel listModel = new DefaultListModel();

    //Creates new form GameServerGUI 
    public GameServerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        serverStart = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        restartButton = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Server");

        serverStart.setText("Start listening");
        serverStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverStartActionPerformed(evt);
            }
        });

        statusLabel.setText("Game status:");

        portTextField.setText("5555");

        jLabel1.setText("Port to listen");

        restartButton.setText("Restart game");
        restartButton.setEnabled(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        connectionLabel.setText("Connection status: none");

        jList2.setModel(listModel);
        jScrollPane2.setViewportView(jList2);

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(connectionLabel)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serverStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(serverStart)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(restartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(connectionLabel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void serverStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverStartActionPerformed
        serverStart.setEnabled(false);
        Thread t = new Thread(new Runnable() {
            public void run() {
                int port = 5555;  //The port number
                try {
                    port = Integer.parseInt(portTextField.getText()); //Get port
                } catch (Throwable t) {
                    port = 5555; //Set port to 5555
                }
                server = new GameServer(port, gameServ);
                //GameServer chat = new GameServer(port);
                //chat.accept();  //Wait for console data
            }
        }, "listening");
        t.start();
        connectionLabel.setText("Connection status: listening");
    }//GEN-LAST:event_serverStartActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        server.sendToAllClients("#restart");
        receiveCommand("enableAll");
//        button1.setText("");
//        button2.setText("");
//        button3.setText("");
//        button4.setText("");
//        button5.setText("");
//        button6.setText("");
//        button7.setText("");
//        button8.setText("");
//        button9.setText("");
        statusLabel.setText("Game restarted");
        if (isServerTurn()) {
            clientFirst = false;
        } else {
            clientFirst = true;
        }
        count = 0;
    }//GEN-LAST:event_restartButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameServerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                gameServ = new GameServerGUI();
                gameServ.setVisible(true);
                //new GameServer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JTextField portTextField;
    private javax.swing.JButton restartButton;
    private javax.swing.JButton serverStart;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void display(String message) {
        System.out.println("> " + message);
    }

    public void accept() {
        try {
            BufferedReader fromConsole =
                    new BufferedReader(new InputStreamReader(System.in));
            String message;

            while (true) {
                message = fromConsole.readLine();
                server.handleMessageFromServerUI(message);
            }
        } catch (Exception ex) {
            System.out.println("Unexpected error while reading from console!" + ex);
        }
    }

    /**
     *
     * @param command
     */
    @Override
    public void receiveCommand(String command) {
        switch (command) {
            case "enableAll": {
                Runnable enable = new Runnable() {
                    public void run() {
//                        button1.setEnabled(true);
//                        button2.setEnabled(true);
//                        button3.setEnabled(true);
//                        button4.setEnabled(true);
//                        button5.setEnabled(true);
//                        button6.setEnabled(true);
//                        button7.setEnabled(true);
//                        button8.setEnabled(true);
//                        button9.setEnabled(true);
                    }
                };
                java.awt.EventQueue.invokeLater(enable);
                break;
            }
            case "disableAll": {
                Runnable enable = new Runnable() {
                    public void run() {
//                        button1.setEnabled(false);
//                        button2.setEnabled(false);
//                        button3.setEnabled(false);
//                        button4.setEnabled(false);
//                        button5.setEnabled(false);
//                        button6.setEnabled(false);
//                        button7.setEnabled(false);
//                        button8.setEnabled(false);
//                        button9.setEnabled(false);
                    }
                };
                java.awt.EventQueue.invokeLater(enable);
                break;
            }
//            case "#1": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button1.setText("O");
//                        button1.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#2": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button2.setText("O");
//                        button2.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#3": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button3.setText("O");
//                        button3.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#4": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button4.setText("O");
//                        button4.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#5": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button5.setText("O");
//                        button5.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#6": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button6.setText("O");
//                        button6.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#7": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button7.setText("O");
//                        button7.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#8": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button8.setText("O");
//                        button8.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
//            case "#9": {
//                Runnable disable = new Runnable() {
//                    public void run() {
//                        button9.setText("O");
//                        button9.setEnabled(false);
//                        count++;
//                        checkWinner();
//                    }
//                };
//                java.awt.EventQueue.invokeLater(disable);
//                break;
//            }
            case "#clientFirst":
                clientFirst = true;
                break;
            case "#serverTurn":
                Runnable temp = new Runnable() {
                    public void run() {
                        statusLabel.setText("Your turn!");
                    }
                };
                java.awt.EventQueue.invokeLater(temp);
                break;
            case "#enableRestart":
                Runnable temp2 = new Runnable() {
                    public void run() {
                        restartButton.setEnabled(true);
                    }
                };
                java.awt.EventQueue.invokeLater(temp2);
                break;
            case "#connected": {
                Runnable disable = new Runnable() {
                    public void run() {
                        connectionLabel.setText("Connection status: connected");
                    }
                };
                java.awt.EventQueue.invokeLater(disable);
                break;
            }
        }
    }

    public void checkWinner() {
//        String win;
//
//        //horizontal
//        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && !"".equals(button1.getText())) {
//            win = button1.getText();
//        } else if (button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && !"".equals(button4.getText())) {
//            win = button4.getText();
//        } else if (button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && !"".equals(button7.getText())) {
//            win = button7.getText();
//        } //vertical
//        else if (button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !"".equals(button1.getText())) {
//            win = button1.getText();
//        } else if (button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !"".equals(button2.getText())) {
//            win = button2.getText();
//        } else if (button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && !"".equals(button3.getText())) {
//            win = button3.getText();
//        } //diagonal
//        else if (button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && !"".equals(button1.getText())) {
//            win = button1.getText();
//        } else if (button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText()) && !"".equals(button3.getText())) {
//            win = button3.getText();
//        } else {
//            win = "";
//        }
//        if (win.equals("X")) {
//            receiveCommand("disableAll");
//            server.sendToAllClients("#serverWon");
//            Runnable temp = new Runnable() {
//                public void run() {
//                    statusLabel.setText("You won!");
//                }
//            };
//            java.awt.EventQueue.invokeLater(temp);
//            //JOptionPane.showMessageDialog(null, "Server won!");   
//        } else if (win.equals("O")) {
//            receiveCommand("disableAll");
//            server.sendToAllClients("#clientWon");
//            Runnable temp = new Runnable() {
//                public void run() {
//                    statusLabel.setText("You lost...");
//                }
//            };
//            java.awt.EventQueue.invokeLater(temp);
//            //JOptionPane.showMessageDialog(null, "Client won!");
//        } else if (count == 9 && win.equals("")) {
//            server.sendToAllClients("#draw");
//            Runnable temp = new Runnable() {
//                public void run() {
//                    statusLabel.setText("Draw game!");
//                }
//            };
//            java.awt.EventQueue.invokeLater(temp);
//        }
    }

    private boolean isServerTurn() {
        boolean isServerTurn = true;
        if ((clientFirst && (count % 2 == 0)) || ((!clientFirst) && (count % 2 == 1))) {
            isServerTurn = false;
        }
        return isServerTurn;
    }

    public void addGame(int gameName, ConnectionToClient client) {
        final String name = gameName + " ";
        final String clientName = client.toString() + " " + client.getName();
        Runnable temp = new Runnable() {
            public void run() {
                listModel.addElement(name + " " + clientName);
                revalidate();
            }
        };
        java.awt.EventQueue.invokeLater(temp);
    }

    @Override
    public void receiveList(DefaultListModel listModel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
