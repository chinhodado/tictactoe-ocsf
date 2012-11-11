
import java.io.*;
import common.*;
import javax.swing.JOptionPane;

/**
 * @author Trung Do
 */
public class GameServerGUI extends javax.swing.JFrame implements GameIF {

    GameServer server;
    static GameServerGUI gameServ;
    static int count = 0;
    public boolean clientFirst = false;

    //Creates new form GameServerGUI 
    public GameServerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        serverStart = new javax.swing.JButton();
        statusLabel = new javax.swing.JLabel();
        portTextField = new javax.swing.JTextField();
        button1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        restartButton = new javax.swing.JButton();
        connectionLabel = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

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

        button1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button1.setEnabled(false);
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Port to listen");

        button2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button2.setEnabled(false);
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button3.setEnabled(false);
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button4.setEnabled(false);
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button5.setEnabled(false);
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button6.setEnabled(false);
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button7.setEnabled(false);
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button8.setEnabled(false);
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        button9.setEnabled(false);
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        restartButton.setText("Restart game");
        restartButton.setEnabled(false);
        restartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restartButtonActionPerformed(evt);
            }
        });

        connectionLabel.setText("Connection status: none");

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
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(serverStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restartButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(portTextField))))))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(connectionLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (isServerTurn()){
        button1.setText("X");
        button1.setEnabled(false);
        server.handleMessageFromServerUI("#1");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (isServerTurn()){
        button2.setText("X");
        button2.setEnabled(false);
        server.handleMessageFromServerUI("#2");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (isServerTurn()){
        button3.setText("X");
        button3.setEnabled(false);
        server.handleMessageFromServerUI("#3");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (isServerTurn()){
        button4.setText("X");
        button4.setEnabled(false);
        server.handleMessageFromServerUI("#4");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
        if (isServerTurn()){
        button5.setText("X");
        button5.setEnabled(false);
        server.handleMessageFromServerUI("#5");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button5ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        if (isServerTurn()){
        button6.setText("X");
        button6.setEnabled(false);
        server.handleMessageFromServerUI("#6");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button6ActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        if (isServerTurn()){
        button7.setText("X");
        button7.setEnabled(false);
        server.handleMessageFromServerUI("#7");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        if (isServerTurn()){
        button8.setText("X");
        button8.setEnabled(false);
        server.handleMessageFromServerUI("#8");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        if (isServerTurn()){
        button9.setText("X");
        button9.setEnabled(false);
        server.handleMessageFromServerUI("#9");
        count++;
        statusLabel.setText("Client's turn");
        checkWinner();
        } else JOptionPane.showMessageDialog(null, "Not your turn!");
    }//GEN-LAST:event_button9ActionPerformed

    private void restartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restartButtonActionPerformed
        server.sendToAllClients("#restart");       
        receiveCommand("enableAll");
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        statusLabel.setText("Game restarted");
        if (isServerTurn()) clientFirst=false;
        else clientFirst=true;
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
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JLabel connectionLabel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
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
            case "enableAll":
                {
                    Runnable enable = new Runnable() {
                        public void run() {
                            button1.setEnabled(true);
                            button2.setEnabled(true);
                            button3.setEnabled(true);
                            button4.setEnabled(true);
                            button5.setEnabled(true);
                            button6.setEnabled(true);
                            button7.setEnabled(true);
                            button8.setEnabled(true);
                            button9.setEnabled(true);
                            //button1.revalidate();
                            //button1.repaint();
                        }
                    };
                    java.awt.EventQueue.invokeLater(enable);
                    break;
                }
            case "disableAll":
                {
                    Runnable enable = new Runnable() {
                        public void run() {
                            button1.setEnabled(false);
                            button2.setEnabled(false);
                            button3.setEnabled(false);
                            button4.setEnabled(false);
                            button5.setEnabled(false);
                            button6.setEnabled(false);
                            button7.setEnabled(false);
                            button8.setEnabled(false);
                            button9.setEnabled(false);
                        }
                    };
                    java.awt.EventQueue.invokeLater(enable);
                    break;
                }
            case "#1":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button1.setText("O");
                            button1.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#2":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button2.setText("O");
                            button2.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#3":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button3.setText("O");
                            button3.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#4":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button4.setText("O");
                            button4.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#5":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button5.setText("O");
                            button5.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#6":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button6.setText("O");
                            button6.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#7":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button7.setText("O");
                            button7.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#8":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button8.setText("O");
                            button8.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
            case "#9":
                {
                    Runnable disable = new Runnable() {
                        public void run() {
                            button9.setText("O");
                            button9.setEnabled(false);
                            count++;
                            checkWinner();
                        }
                    };
                    java.awt.EventQueue.invokeLater(disable);
                    break;
                }
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
            case "#connected":
                {
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
        String win;

        //horizontal
        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && !"".equals(button1.getText())) {
            win = button1.getText();
        } else if (button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && !"".equals(button4.getText())) {
            win = button4.getText();
        } else if (button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && !"".equals(button7.getText())) {
            win = button7.getText();
        } //vertical
        else if (button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !"".equals(button1.getText())) {
            win = button1.getText();
        } else if (button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !"".equals(button2.getText())) {
            win = button2.getText();
        } else if (button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && !"".equals(button3.getText())) {
            win = button3.getText();
        } //diagonal
        else if (button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && !"".equals(button1.getText())) {
            win = button1.getText();
        } else if (button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText()) && !"".equals(button3.getText())) {
            win = button3.getText();
        } else {
            win = "";
        }
        if (win.equals("X")) {
            receiveCommand("disableAll");
            server.sendToAllClients("#serverWon");
            Runnable temp = new Runnable() {
                public void run() {
                    statusLabel.setText("You won!");
                }
            };
            java.awt.EventQueue.invokeLater(temp);
            //JOptionPane.showMessageDialog(null, "Server won!");   
        } else if (win.equals("O")) {
            receiveCommand("disableAll");
            server.sendToAllClients("#clientWon");
            Runnable temp = new Runnable() {
                public void run() {
                    statusLabel.setText("You lost...");
                }
            };
            java.awt.EventQueue.invokeLater(temp);
            //JOptionPane.showMessageDialog(null, "Client won!");
        } else if (count == 9 && win.equals("")) {
            server.sendToAllClients("#draw");
            Runnable temp = new Runnable() {
                public void run() {
                    statusLabel.setText("Draw game!");
                }
            };
            java.awt.EventQueue.invokeLater(temp);
        }
    }
    
    private boolean isServerTurn()
    {
        boolean isServerTurn=true;
        if ((clientFirst&&(count%2==0))||((!clientFirst)&&(count%2==1))) isServerTurn=false;
        return isServerTurn;
    }
    
    
}
