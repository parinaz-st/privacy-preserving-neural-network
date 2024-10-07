//package org.example.socket;
//
//import java.awt.event.ActionListener;
//import java.awt.FlowLayout;
//import java.math.*;
//import java.util.*;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.math.BigInteger;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;
//
//public class ActionHandler extends BobServer implements ActionListener
//{
//    public void actionPerformed( ActionEvent event )
//    {
//        if (event.getSource() == startListeningBtn)
//        {
//            try
//            {
//                startListening();
//                JOptionPane.showMessageDialog(null, "Server Is Listening On Port Number "+ BobReciveTxtf.getText(),"Connection Status" , JOptionPane.PLAIN_MESSAGE);
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//        else if (event.getSource() == StopServer)
//        {
//            if (serverStarted && (sclientNumber==0))//kasi be sevrev vasl nabashe
//            {
//                try
//                {
//                    if (!listener.isClosed())
//                    {
//                        serverStarted = false;
//                        listener.close();
//                        System.out.println("The Bob server is stopped.");
//                    }
//                }
//                catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//            }
//            else if (sclientNumber>0)
//            {
//                System.out.println("The Bob server cannot be stopped because it has active clients.");
//                System.out.println(sclientNumber);
//            }
//        }
//    }
//    public void startListening() throws Exception
//    {
//        if (!serverStarted)
//        {
//            serverThread = new Thread(
//                    new Runnable()
//                    {
//                        @Override
//                        public void run()
//                        {
//                            try
//                            {
//                                listener = new ServerSocket(Integer.parseInt(BobReciveTxtf.getText()));
//                                sclientNumber = 0;
//                                System.out.println("The Bob server is running.");
//                                //ino man gozashtam inja chio migire?
//                                System.out.println(BobReciveTxtf.getText());
//
//                                try
//                                {
//                                    while (true)
//                                    {
//                                        if (!listener.isClosed() && serverStarted)
//                                            new Capitalizer(listener.accept(), sclientNumber++).start();
//                                        else
//                                            break;
//                                    }
//                                }
//                                finally
//                                {
//                                    if (!listener.isClosed() && serverStarted)
//                                    {
//                                        serverStarted = false;
//                                        listener.close();
//                                        sclientNumber = 0;
//                                        System.out.println("The Bob server is stoppedd.");
//                                    }
//                                }
//                            } catch (Exception e) {
//                                if (serverStarted)
//                                    e.printStackTrace();
//                            }
//                        }
//                    }
//            );
//            serverThread.start();
//            serverStarted = true;
//        }
//
//    }
//
//    public static class Capitalizer extends Thread
//    {
//
//
//        public Socket socket;
//        public int clientNumber;
//
//        public Capitalizer(Socket socket, int clientNumber)
//        {
//
//            this.socket = socket;
//            this.clientNumber = clientNumber;
//            log("New connection with client# " + clientNumber + " at " + socket);
//        }
//
//        /**
//         * Services this thread's client by first sending the
//         * client a welcome message then repeatedly reading strings
//         * and sending back the capitalized version of the string.
//         */
//        public void run()
//        {
//            try {
//
//                // Decorate the streams so we can send characters
//                // and not just bytes.  Ensure output is flushed
//                // after every newline.
//                BufferedReader in = new BufferedReader(
//                        new InputStreamReader(socket.getInputStream()));
//                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//
//                // Send a weight signs to client.
//                out.println(Integer.toString(weightSign1));
//                out.println(Integer.toString(weightSign2));
//
//                //out.println("Enter a line with only a period to quit\n");
//
//                // Get messages from the client, line by line; return them
//                // capitalized
//                while (true)
//                {
//                    cipherTextStr1 = in.readLine();
//                    cipherTextBigInt1 = new BigInteger(cipherTextStr1);
//
//                    if (cipherTextStr1  == null)
//                    {
//                        break;
//                    }
////                    System.out.println("Bob recived cipher text1:");
////                    System.out.println(cipherTextStr1);
////                    System.out.println("cipherTextBigInt1:");
////                    System.out.println(cipherTextBigInt1);
//
//
//                    cipherTextStr2 = in.readLine();
//                    cipherTextBigInt2 = new BigInteger(cipherTextStr2);
//                    if (cipherTextStr2 == null)
//                    {
//                        break;
//                    }
////                    System.out.println("Bob recived cipher text2: ");
////                    System.out.println(cipherTextStr2);
////                    System.out.println("cipherTextBigInt2:");
////                    System.out.println(cipherTextBigInt2);
//
//                    nSquare = new BigInteger(in.readLine());
//                    if (nSquare == null)
//                    {
//                        break;
//                    }
//
////                    System.out.println("Bob recived nSquare: ");
////                    System.out.println(nSquare);
//
//                    scalarProductRes = computeScalarProduct();
////                    System.out.println("Bob scalar product result: ");
////                    System.out.println(scalarProductRes);
//
//                    out.println(scalarProductRes.toString());
////                   out.println(input.toUpperCase());
//                }
//            } catch (IOException e) {
//                log("Error handling client# " + clientNumber + ": " + e);
//            } finally {
//                try {
//                    sclientNumber--;
//                    socket.close();
//                } catch (IOException e) {
//                    log("Couldn't close a socket, what's going on?");
//                }
//                log("Connection with client# " + clientNumber + " closed");
//            }
//        }
//
//        /**
//         * Logs a simple message.  In this case we just write the
//         * message to the server applications standard output.
//         */
//        private void log(String message) {
//            System.out.println(message);
//        }
//    }
//
//    public static BigInteger computeScalarProduct()
//    {
//        w1c1  = cipherTextBigInt1.modPow(weightParameterBigInt1, nSquare);
//
////     System.out.println("w1c1:");
////     System.out.println(w1c1.toString());
//
//        w2c2 = cipherTextBigInt2.modPow(weightParameterBigInt2, nSquare);
////     System.out.println("w2c2:");
////     System.out.println(w2c2.toString());
//
//        w = w1c1.multiply(w2c2).mod(nSquare);
////     System.out.println("w:");
////     System.out.println(w.toString());
//
//        return w;
//    }
//
//}
