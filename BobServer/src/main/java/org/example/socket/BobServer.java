//package org.example.socket;
//
//import javax.swing.*;
//import java.math.BigInteger;
//import java.net.ServerSocket;
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
//public class BobServer extends JFrame {
//    public JLabel weightLabel1;
//    public JLabel weightLabel2;
//    public JTextField weightTxtf1;
//    public JTextField weightTxtf2;
//
//    public  static BigInteger weightParameterBigInt1;
//    public static BigInteger weightParameterBigInt2;
//
//    public double weightparameter1;
//    public double weightparameter2;
//
//    public String weightStr1;
//    public String weightStr2;
//    public int weightParameterInt1;
//    public int weightParameterInt2;
//
//    public  static int weightSign1;
//    public  static int weightSign2;
//
//    public static String cipherTextStr1;
//    public static String cipherTextStr2;
//
//    public static BigInteger cipherTextBigInt1;
//    public static BigInteger cipherTextBigInt2;
//    public static BigInteger w1c1;
//    public static BigInteger w2c2;
//    public static BigInteger w;
//
//    public JTextField BobReciveTxtf;
//    public JButton StopServer;
//    public JButton startListeningBtn;
//    public JLabel startListeningLabel;
//    public Thread serverThread;
//    public boolean serverStarted;
//    public ServerSocket listener;
//    public static int sclientNumber;
//    public static BigInteger nSquare;
//    public static BigInteger scalarProductRes;
//
//    public BobServer()
//    {
//        super("Bob Form");
//
//        int xlen = 100;
//        int ylen = 100;
//
//        int dx = 10; // horizontal --
//        int dy = 30; // vertical |
//        int space = 10; //space both
//
//        int xloc;
//        int yloc;
//
//        // row 0
//        xloc = space;
//        yloc = space;
//
//        setLayout( null );
//
//        startListeningBtn = new JButton("Start Listening");
//        yloc = yloc + space;
//        startListeningBtn.setLocation(xloc, yloc);
//        startListeningBtn.setSize(150,dy);
//        xloc = xloc + 150 + dx;
//        add(startListeningBtn);
//        xloc = space ;
//        yloc = yloc + dy + space;
//
//        // row
//
//        startListeningLabel = new JLabel(" Port Number:");
//        startListeningLabel.setLocation(xloc, yloc);
//        startListeningLabel.setSize(100,dy);
//        xloc = xloc + 100 + dx;
//
//        add(startListeningLabel);
//
//        BobReciveTxtf = new JTextField("9001",20);
//        BobReciveTxtf.setLocation(xloc, yloc);
//        BobReciveTxtf.setSize(100,dy);
//        xloc = xloc + 100 + dx;
//        add(BobReciveTxtf);
//        xloc = space ;
//        yloc = yloc + dy + space;
//
//        StopServer = new JButton("Stop Server");
//        StopServer.setLocation(xloc, yloc);
//        StopServer.setSize(150,dy);
//        xloc = xloc + 150 + dx;
//
//        add(StopServer);
//
//        ActionHandler handler = new ActionHandler();
//        startListeningBtn.addActionListener(handler);
//        StopServer.addActionListener(handler);
//        serverStarted = false;
//        sclientNumber = 0;
//
//    }
//   public void readFileWeightstext(String fileName) throws IOException
//    {
//        BufferedReader br = new BufferedReader(new FileReader(fileName));
//        try
//        {
//            weightStr1 = br.readLine();
//            weightStr2 = br.readLine();
//
////	        System.out.println("weightStr1:");
////	        System.out.println(weightStr1);
////	        System.out.println("weightStr2:");
////	        System.out.println(weightStr2);
//
//            //weightTxtf1.setText(weightStr1);
//            //weightTxtf2.setText(weightStr2);
//            weightparameter1 = Double.parseDouble(weightStr1);
//            weightparameter2 = Double.parseDouble(weightStr2);
//
////	        System.out.println("weightparameter1:");
////	        System.out.println(weightparameter1);
////	        System.out.println("weightparameter2:");
////	        System.out.println(weightparameter2);
//
//            weightParameterInt1 = (int)(weightparameter1 * 100);
//            weightParameterInt2 = (int)(weightparameter2 * 100);
//
////	        System.out.println("weightParameterInt1 :");
////	        System.out.println(weightParameterInt1);
////	        System.out.println("weightParameterInt2 :");
////	        System.out.println(weightParameterInt2);
//
//            weightStr1 = Integer.toString(weightParameterInt1);
//            weightStr2 = Integer.toString(weightParameterInt2);
//
////	        System.out.println("weightStr1:");
////	        System.out.println(weightStr1);
//
//            weightParameterBigInt1 = new BigInteger(weightStr1);
//            weightParameterBigInt2 = new BigInteger(weightStr2);
////	        System.out.println("weightParameterBigInt1 :");
////	        System.out.println(weightParameterBigInt1);
//            BigInteger manfi = new BigInteger("-1");
//
//            if(weightparameter1 < 0)
//            {
//                weightSign1 = -1;
//                weightParameterBigInt1 = weightParameterBigInt1.multiply(manfi);
//
//
//            }
//            else
//            {
//                weightSign1 = 1;
//            }
//            if(weightparameter2 < 0)
//            {
//                weightSign2 = -1;
//                weightParameterBigInt2 = weightParameterBigInt2.multiply(manfi);
//            }
//            else
//            {
//                weightSign2 = 1;
//            }
////	        System.out.println(weightParameterBigInt1);
////	        System.out.println(weightParameterBigInt2);
//
//            //    writeNegativeCoumn(negativeCol, "negativeColumn.txt");
//        }
//        finally
//        {
//            br.close();
//        }
//    }
//
//}
