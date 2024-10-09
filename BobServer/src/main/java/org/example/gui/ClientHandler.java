package org.example.gui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientHandler extends Thread {
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class.getName());
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        LOGGER.info("Handling client: " + socket.getInetAddress());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            // Example of reading and computing scalar product
            String cipherText1 = in.readLine();
            LOGGER.info("Received cipherText1 from client: " + cipherText1);

            String cipherText2 = in.readLine();
            LOGGER.info("Received cipherText2 from client: " + cipherText2);

            if (cipherText1 != null && cipherText2 != null) {
                BigInteger result = WeightCalculator.computeScalarProduct(
                        new BigInteger(cipherText1),
                        new BigInteger(cipherText2)
                );
                LOGGER.info("Computed scalar product: " + result);
                out.println(result); // Send the result back to the client
            } else {
                LOGGER.warning("Received null data from client.");
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error handling client: ", e);
        } finally {
            try {
                socket.close(); // Close the client socket after serving
                LOGGER.info("Client connection closed: " + socket.getInetAddress());
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Error closing client socket: ", e);
            }
        }
    }
}

