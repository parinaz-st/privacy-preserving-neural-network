package org.example;
import java.awt.FlowLayout;
import java.math.*;
import java.util.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MainBobApp extends JFrame
{
//    public static void main(String[] args)throws Exception
//    {
//        BobServer BobForm = new BobServer();
//        BobForm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        BobForm.setSize( 300,200 );
//        BobForm.setVisible( true );
//        BobForm.readFileWeightstext("weights.txt");
//    }
//}

//package tahvilProje;




//import AliceBobSocket.AliceClient.ActionHandler;

//public class BobServer extends JFrame
//{


    public JLabel weightLabel1;
    public JLabel weightLabel2;
    public JTextField weightTxtf1;
    public JTextField weightTxtf2;

    public  static BigInteger weightParameterBigInt1;
    public static BigInteger weightParameterBigInt2;

    public double weightparameter1;
    public double weightparameter2;

    public String weightStr1;
    public String weightStr2;
    public int weightParameterInt1;
    public int weightParameterInt2;

    public  static int weightSign1;
    public  static int weightSign2;

    public static String cipherTextStr1;
    public static String cipherTextStr2;

    public static BigInteger cipherTextBigInt1;
    public static BigInteger cipherTextBigInt2;
    public static BigInteger w1c1;
    public static BigInteger w2c2;
    public static BigInteger w;

    public JTextField BobReciveTxtf;
    public JButton StopServer;
    public JButton startListeningBtn;
    public JLabel startListeningLabel;
    public Thread serverThread;
    public boolean serverStarted;
    public ServerSocket listener;
    public static int sclientNumber;
    public static BigInteger nSquare;
    public static BigInteger scalarProductRes;

    public MainBobApp()
    {
        super("Bob Form");

        int xlen = 100;
        int ylen = 100;

        int dx = 10; // horizontal --
        int dy = 30; // vertical |
        int space = 10; //space both

        int xloc;
        int yloc;

        // row 0
        xloc = space;
        yloc = space;

        setLayout( null );

        startListeningBtn = new JButton("Start Listening");
        yloc = yloc + space;
        startListeningBtn.setLocation(xloc, yloc);
        startListeningBtn.setSize(150,dy);
        xloc = xloc + 150 + dx;
        add(startListeningBtn);
        xloc = space ;
        yloc = yloc + dy + space;

        // row

        startListeningLabel = new JLabel(" Port Number:");
        startListeningLabel.setLocation(xloc, yloc);
        startListeningLabel.setSize(100,dy);
        xloc = xloc + 100 + dx;

        add(startListeningLabel);

        BobReciveTxtf = new JTextField("9011",20);
        BobReciveTxtf.setLocation(xloc, yloc);
        BobReciveTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx;
        add(BobReciveTxtf);
        xloc = space ;
        yloc = yloc + dy + space;

        StopServer = new JButton("Stop Server");
        StopServer.setLocation(xloc, yloc);
        StopServer.setSize(150,dy);
        xloc = xloc + 150 + dx;

        add(StopServer);

        ActionHandler handler = new ActionHandler();
        startListeningBtn.addActionListener(handler);
        StopServer.addActionListener(handler);
        serverStarted = false;
        sclientNumber = 0;

    }
    public class ActionHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            if (event.getSource() == startListeningBtn)
            {
                try
                {
                    startListening();
                    JOptionPane.showMessageDialog(null, "Server Is Listening On Port Number "+ BobReciveTxtf.getText(),"Connection Status" , JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e) {

                    e.printStackTrace();
                }
            }
            else if (event.getSource() == StopServer)
            {
                if (serverStarted && (sclientNumber==0))//kasi be sevrev vasl nabashe
                {
                    try
                    {
                        if (!listener.isClosed())
                        {
                            serverStarted = false;
                            listener.close();
                            System.out.println("The Bob server is stopped.");
                        }
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else if (sclientNumber>0)
                {
                    System.out.println("The Bob server cannot be stopped because it has active clients.");
                    System.out.println(sclientNumber);
                }
            }
        }
    }
    public static void main(String[] args)throws Exception
    {
        MainBobApp BobForm = new MainBobApp();
        BobForm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        BobForm.setSize( 300,200 );
        BobForm.setVisible( true );
        BobForm.readFileWeightstext("E://Sattarzadeh//Codes//github//neural-network-project//PPNN//BobServer//src//main//java//org//example//weights.txt");
    }
    public void startListening() throws Exception
    {
        if (!serverStarted)
        {
            serverThread = new Thread(
                    new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            try
                            {
                                listener = new ServerSocket(Integer.parseInt(BobReciveTxtf.getText()));
                                sclientNumber = 0;
                                System.out.println("The Bob server is running.");
                                //ino man gozashtam inja chio migire?
                                System.out.println(BobReciveTxtf.getText());

                                try
                                {
                                    while (true)
                                    {
                                        if (!listener.isClosed() && serverStarted)
                                            new Capitalizer(listener.accept(), sclientNumber++).start();
                                        else
                                            break;
                                    }
                                }
                                finally
                                {
                                    if (!listener.isClosed() && serverStarted)
                                    {
                                        serverStarted = false;
                                        listener.close();
                                        sclientNumber = 0;
                                        System.out.println("The Bob server is stoppedd.");
                                    }
                                }
                            } catch (Exception e) {
                                if (serverStarted)
                                    e.printStackTrace();
                            }
                        }
                    }
            );
            serverThread.start();
            serverStarted = true;
        }

    }
    public static class Capitalizer extends Thread
    {


        public Socket socket;
        public int clientNumber;

        public Capitalizer(Socket socket, int clientNumber)
        {

            this.socket = socket;
            this.clientNumber = clientNumber;
            log("New connection with client# " + clientNumber + " at " + socket);
        }

        /**
         * Services this thread's client by first sending the
         * client a welcome message then repeatedly reading strings
         * and sending back the capitalized version of the string.
         */
        public void run()
        {
            try {

                // Decorate the streams so we can send characters
                // and not just bytes.  Ensure output is flushed
                // after every newline.
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // Send a weight signs to client.
                out.println(Integer.toString(weightSign1));
                out.println(Integer.toString(weightSign2));

                //out.println("Enter a line with only a period to quit\n");

                // Get messages from the client, line by line; return them
                // capitalized
                while (true)
                {
                    cipherTextStr1 = in.readLine();
                    cipherTextBigInt1 = new BigInteger(cipherTextStr1);

                    if (cipherTextStr1  == null)
                    {
                        break;
                    }
//                    System.out.println("Bob recived cipher text1:");
//                    System.out.println(cipherTextStr1);
//                    System.out.println("cipherTextBigInt1:");
//                    System.out.println(cipherTextBigInt1);


                    cipherTextStr2 = in.readLine();
                    cipherTextBigInt2 = new BigInteger(cipherTextStr2);
                    if (cipherTextStr2 == null)
                    {
                        break;
                    }
//                    System.out.println("Bob recived cipher text2: ");
//                    System.out.println(cipherTextStr2);
//                    System.out.println("cipherTextBigInt2:");
//                    System.out.println(cipherTextBigInt2);

                    nSquare = new BigInteger(in.readLine());
                    if (nSquare == null)
                    {
                        break;
                    }

//                    System.out.println("Bob recived nSquare: ");
//                    System.out.println(nSquare);

                    scalarProductRes = computeScalarProduct();
//                    System.out.println("Bob scalar product result: ");
//                    System.out.println(scalarProductRes);

                    out.println(scalarProductRes.toString());
//                   out.println(input.toUpperCase());
                }
            } catch (IOException e) {
                log("Error handling client# " + clientNumber + ": " + e);
            } finally {
                try {
                    sclientNumber--;
                    socket.close();
                } catch (IOException e) {
                    log("Couldn't close a socket, what's going on?");
                }
                log("Connection with client# " + clientNumber + " closed");
            }
        }

        /**
         * Logs a simple message.  In this case we just write the
         * message to the server applications standard output.
         */
        private void log(String message) {
            System.out.println(message);
        }
    }

    void readFileWeightstext(String fileName) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            weightStr1 = br.readLine();
            weightStr2 = br.readLine();

//	        System.out.println("weightStr1:");
//	        System.out.println(weightStr1);
//	        System.out.println("weightStr2:");
//	        System.out.println(weightStr2);

            //weightTxtf1.setText(weightStr1);
            //weightTxtf2.setText(weightStr2);
            weightparameter1 = Double.parseDouble(weightStr1);
            weightparameter2 = Double.parseDouble(weightStr2);

//	        System.out.println("weightparameter1:");
//	        System.out.println(weightparameter1);
//	        System.out.println("weightparameter2:");
//	        System.out.println(weightparameter2);

            weightParameterInt1 = (int)(weightparameter1 * 100);
            weightParameterInt2 = (int)(weightparameter2 * 100);

//	        System.out.println("weightParameterInt1 :");
//	        System.out.println(weightParameterInt1);
//	        System.out.println("weightParameterInt2 :");
//	        System.out.println(weightParameterInt2);

            weightStr1 = Integer.toString(weightParameterInt1);
            weightStr2 = Integer.toString(weightParameterInt2);

//	        System.out.println("weightStr1:");
//	        System.out.println(weightStr1);

            weightParameterBigInt1 = new BigInteger(weightStr1);
            weightParameterBigInt2 = new BigInteger(weightStr2);
//	        System.out.println("weightParameterBigInt1 :");
//	        System.out.println(weightParameterBigInt1);
            BigInteger manfi = new BigInteger("-1");

            if(weightparameter1 < 0)
            {
                weightSign1 = -1;
                weightParameterBigInt1 = weightParameterBigInt1.multiply(manfi);


            }
            else
            {
                weightSign1 = 1;
            }
            if(weightparameter2 < 0)
            {
                weightSign2 = -1;
                weightParameterBigInt2 = weightParameterBigInt2.multiply(manfi);
            }
            else
            {
                weightSign2 = 1;
            }
//	        System.out.println(weightParameterBigInt1);
//	        System.out.println(weightParameterBigInt2);

            //    writeNegativeCoumn(negativeCol, "negativeColumn.txt");
        }
        finally
        {
            br.close();
        }
    }
    public static BigInteger computeScalarProduct()
    {
        w1c1  = cipherTextBigInt1.modPow(weightParameterBigInt1, nSquare);

//     System.out.println("w1c1:");
//     System.out.println(w1c1.toString());

        w2c2 = cipherTextBigInt2.modPow(weightParameterBigInt2, nSquare);
//     System.out.println("w2c2:");
//     System.out.println(w2c2.toString());

        w = w1c1.multiply(w2c2).mod(nSquare);
//     System.out.println("w:");
//     System.out.println(w.toString());

        return w;
    }

}
