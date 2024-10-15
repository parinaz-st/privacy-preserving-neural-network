package org.example.gui;


import org.example.MainBobApp;

import javax.swing.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServerManager {
    private static final Logger LOGGER = Logger.getLogger(ServerManager.class.getName());
    private MainBobApp app;
    private ServerSocket serverSocket;
    private boolean serverRunning = false;
    private Thread serverThread;

    public ServerManager(MainBobApp app) {
        this.app = app;
    }

    public void startServer() {
        if (!serverRunning) {
            try {
                int port = Integer.parseInt(app.getPort());
                LOGGER.info("Starting server on port " + port);
                serverSocket = new ServerSocket(port);
                serverThread = new Thread(() -> {
                    try {
                        serverRunning = true;
                        LOGGER.info("Server is running and awaiting client connections...");
                        while (serverRunning && !serverSocket.isClosed()) {
                            Socket socket = serverSocket.accept();
                            LOGGER.info("Client connected: " + socket.getInetAddress());
                            new ClientHandler(socket).start(); // Handle each client in a separate thread
                        }
                    } catch (Exception e) {
                        if (serverRunning) {
                            LOGGER.log(Level.SEVERE, "Error in server thread: ", e);
                        }
                    }
                });
                serverThread.start();
                JOptionPane.showMessageDialog(null, "Server started on port " + port);
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error starting the server: ", e);
            }
        }
    }

    public void stopServer() {
        if (serverRunning) {
            try {
                LOGGER.info("Stopping server...");
                serverRunning = false;
                if (serverSocket != null && !serverSocket.isClosed()) {
                    serverSocket.close(); // Close the server socket
                    LOGGER.info("Server stopped.");
                }
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error stopping the server: ", e);
            }
        }
    }
}

