package org.example.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

    public class MainBobApp extends JFrame {
        private JTextField portTextField;
        private JButton startServerButton;
        private JButton stopServerButton;
        private ServerManager serverManager;

        public MainBobApp() {
            super("Bob Form");
            initializeComponents();
            serverManager = new ServerManager(this);
        }

        private void initializeComponents() {
            setLayout(null);

            // Set up start button
            startServerButton = new JButton("Start Listening");
            startServerButton.setBounds(10, 10, 150, 30);
            add(startServerButton);

            JLabel portLabel = new JLabel("Port Number:");
            portLabel.setBounds(10, 50, 100, 30);
            add(portLabel);

            portTextField = new JTextField("9012", 20);
            portTextField.setBounds(120, 50, 100, 30);
            add(portTextField);

            // Set up stop button
            stopServerButton = new JButton("Stop Server");
            stopServerButton.setBounds(10, 90, 150, 30);
            add(stopServerButton);

            ActionListener actionHandler = new ButtonActionListener(this);
            startServerButton.addActionListener(actionHandler);
            stopServerButton.addActionListener(actionHandler);

            setSize(300, 200);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public String getPort() {
            return portTextField.getText();
        }

        public JButton getStartServerButton() {
            return startServerButton;
        }

        public JButton getStopServerButton() {
            return stopServerButton;
        }

        public ServerManager getServerManager() {
            return serverManager;
        }

        public static void main(String[] args) {
            new MainBobApp();
        }
    }
