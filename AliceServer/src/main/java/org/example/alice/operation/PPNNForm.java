package org.example.alice.operation;

//package tahvilProje;


//package privacy.preserving.neural.network.computation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.text.StyledEditorKit.BoldAction;

import java.awt.Color;

//import AliceBobSocket.PaillierCryptoSystem;



public class PPNNForm extends JFrame
{

    public int bitLength;
    public int colSign1;
    public int colSign2;
    public int serverPortNumber;
    public int plainTextPart1Int;
    public int plainTextPart2Int;
    public int counter;

    public double plainTextPart1;
    public double plainTextPart2;
    public double percent;
    public double zDouble;
    public double thresholdValue;


    public String pNum;
    public String qNum;
    public String nNum;
    public String gNum;
    public String lamdaNum;
    public String uNum;
    public String serverAddress;


    public BigInteger n;
    public BigInteger g;
    public BigInteger lambda;
    public BigInteger u;
    public BigInteger cipherText1;
    public BigInteger cipherText2;
    public BigInteger plainTextBigIntPart1;
    public BigInteger plainTextBigIntPart2;
    public BigInteger scalarProductResultBigInt;
    public BigInteger z;
    public BigInteger devideparameter;
    public BigInteger w;

    public String devideParameterStr;
    public String zDoubleStr;


    public BufferedReader  in;
    public PrintWriter out;
    public Socket socket;

    public ArrayList<String> inputArrayList;
    public ArrayList<String> outputArrayList;
    public ArrayList<Integer> testlabelArrayList;
    public ArrayList<String> testlabelArrayListStr;
    public ArrayList<Integer> testActualLabelArrayList;
    public ArrayList<Double>  outputArrayListDouble;

    public JSeparator line = new JSeparator(SwingConstants.HORIZONTAL);


//*******************************************************************************
//*******************************************************************************
//**********************************key Generation *********************************

    // set up row 1

    //	Font font = new Font(font, BoldAction, size);
    JPanel row1 = new JPanel();
    public JLabel part1Header = new JLabel("Key Generation");
    public JLabel bitLengthLb = new JLabel("Enter Bit Length: ");
    public JTextField bitLengthTxtf = new JTextField("1024", 5);

    //set up row 2
    JPanel row2 = new JPanel();
    public JButton generateKeyBtm = new JButton("Generate Key!");

    //set up row 3
    JPanel row3 = new JPanel();
    public JLabel publicKeyLabel =  new JLabel("Public Key(n,g) = ");

    //set up row 4
    JPanel row4 = new JPanel();
    public JLabel pLabel = new JLabel("p : ", SwingConstants.RIGHT);
    public JTextField pTxtf = new JTextField("1",20);
    public JLabel qLabel = new JLabel("q : ", SwingConstants.RIGHT);
    public JTextField qTxtf = new JTextField("1",20);
    public JLabel nLabel = new JLabel("n=(p*q) : ", SwingConstants.RIGHT);
    public JTextField nTxtf = new JTextField("1",20);
    public JLabel gLabel = new JLabel("g : ", SwingConstants.RIGHT);
    public JTextField gTxtf = new JTextField("1",20);

    //set up row 5
    JPanel row5 = new JPanel();
    public JLabel privateKeyLabel = new JLabel("Private Key(lambda, u)= ");

    //set up row 6
    JPanel row6 = new JPanel();
    public JLabel lambdaLabel = new JLabel("lambda : ", SwingConstants.RIGHT);
    public JTextField lambdaTxtf =  new JTextField("1",20);
    public JLabel uLabel = new JLabel("u : ", SwingConstants.RIGHT);
    public JTextField uTxtf = new JTextField("1",20);

//*****************************************************************************
//*****************************************************************************
//***************************Connection To Server******************************

    //row 7
    public JLabel part2Header = new JLabel("Connection To Server");

    JPanel row7 = new JPanel();
    public JLabel servarAddressLabel = new JLabel("Server Adderss: ");
    public JTextField serverAddressTxtf = new JTextField("127.0.0.1", 10);
    public JLabel serverPortNumLabel = new JLabel("Server Port Number: ");
    public JTextField serverPortNumTxtf = new JTextField("9012", 10);
    public JButton connectToServerBtn = new JButton("Connect to Server");


//*****************************************************************************
//*****************************************************************************
//***************************Crypto******************************

    //row 8
    public JLabel part3Header = new JLabel("Privacy Preserving Scalar Product Protocol");

    public JButton getPlainText = new JButton("Load Input");
    public JTextField loadInputTxtf = new JTextField("E:\\Sattarzadeh\\Codes\\github\\neural-network-project\\PPNN\\AliceServer\\src\\main\\java\\org\\example\\alice\\operation\\files\\plainText.txt");

    //row 9
    public JButton runPSPP = new JButton("Run PSPP Protocol");


    //row 10
    public JLabel part4Header = new JLabel("Classification");

    public JLabel scalarProductResultlabel = new JLabel("Scalar Product Result: ");
    public JTextArea scalarProductResultArea = new JTextArea(40, 10);

    //row 10
    public JLabel thresholdLabel = new JLabel("Threshold value: ");
    public JTextField thresholdTxtf = new JTextField("0.5", 5);

    //row 11

    public JButton classificationBtn = new JButton("Classify Input Data In 2 Classes");

    //row 12
    public JLabel trainDatasetSizelabel = new JLabel("Size of Train Data Set: ", SwingConstants.RIGHT);
    public JTextField trainDatasetSizeTxtf = new JTextField("400", 10);
    public JLabel testDataSetSizelabel = new JLabel("Size of Test Data Set: ", SwingConstants.RIGHT);
    public JTextField testDataSetSizeTxtf = new JTextField("30", 10);
    public JLabel errorRatelabel = new JLabel("Error rate :", SwingConstants.RIGHT);
    public JTextField errorRateTxtf = new JTextField("0.0", 5);





    public  PPNNForm()
    {
        super("Alice Form");
        //GridLayout layout = new GridLayout(13, 1, 5, 5);
        setLayout(null);

        //*******************************************************************************
        //*******************************************************************************
        //********************************** key Generation *****************************
        int xlen = 800;
        int ylen = 500;

        int dx = 10; // horizontal --
        int dy = 30; // vertical |
        int space = 10; //space both

        int xloc;
        int yloc;

        // row 0
        xloc = space;
        yloc = space;

        part1Header.setLocation(300, yloc);
        part1Header.setSize(200, dy);
        part1Header.setForeground(Color.red);
        //part1Header.setFont(BOLD);
        add(part1Header);

        //row 1
        yloc = yloc + dy+space + space;
        bitLengthLb.setLocation(xloc, yloc);
        bitLengthLb.setSize(100,dy);
        xloc = xloc + 100 + dx;

        bitLengthTxtf.setLocation(xloc , yloc);
        bitLengthTxtf.setSize(50,dy);
        xloc = xloc + 50 + dx + dx;

        generateKeyBtm.setLocation(xloc, yloc);
        generateKeyBtm.setSize(120,dy);
        xloc = xloc + 120 + dx ;

//		line.setBounds(400, dy, 1, 1);
//		line.setVisible(true);

        add(bitLengthLb);
        add(bitLengthTxtf);
        add(generateKeyBtm);
        //add(line);

        //row 2
        xloc = space ;
        yloc = yloc + dy + space + space;

        publicKeyLabel.setForeground(Color.blue);
        publicKeyLabel.setLocation(xloc , yloc);
        publicKeyLabel.setSize(100,dy);
        xloc = xloc + 171 + dx ;

        pLabel.setLocation(xloc , yloc);
        pLabel.setSize(30,dy);
        xloc = xloc + 30 + dx ;

        pTxtf.setLocation(xloc , yloc);
        pTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        qLabel.setLocation(xloc, yloc);
        qLabel.setSize(30,dy);
        xloc = xloc + 30 + dx ;

        qTxtf.setLocation(xloc , yloc);
        qTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        nLabel.setLocation(xloc , yloc);
        nLabel.setSize(50,dy);
        xloc = xloc + 50 + dx ;

        nTxtf.setLocation(xloc , yloc);
        nTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        gLabel.setLocation(xloc , yloc);
        gLabel.setSize(30,dy);
        xloc = xloc + 30 + dx ;

        gTxtf.setLocation(xloc , yloc);
        gTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        add(publicKeyLabel);
        add(pLabel);
        add(pTxtf);
        add(qLabel);
        add(qTxtf);
        add(nLabel);
        add(nTxtf);


        //row 3
        xloc = space ;
        yloc = yloc + dy + space + space;

        privateKeyLabel.setForeground(Color.blue);
        privateKeyLabel.setLocation(xloc , yloc);
        privateKeyLabel.setSize(150,dy);
        xloc = xloc + 150 + dx ;

        lambdaLabel.setLocation(xloc , yloc);
        lambdaLabel.setSize(51,dy);
        xloc = xloc + 50 + dx ;

        lambdaTxtf.setLocation(xloc , yloc);
        lambdaTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        gLabel.setLocation(xloc , yloc);
        gLabel.setSize(30,dy);
        xloc = xloc + 30 + dx ;

        gTxtf.setLocation(xloc , yloc);
        gTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        add(privateKeyLabel);
        add(lambdaLabel);
        add(lambdaTxtf);
        add(gLabel);
        add(gTxtf);
        xloc = space ;
        yloc = yloc + dy + space + space;

        //*****************************************************************************
        //*****************************************************************************
        //***************************Connection To Server******************************

        //row 4
        part2Header.setForeground(Color.red);
        part2Header.setLocation(300, yloc);
        part2Header.setSize(200, dy);
        add(part2Header);

        xloc = space ;
        yloc = yloc + dy + space + space;

        servarAddressLabel.setLocation(xloc , yloc);
        servarAddressLabel.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        serverAddressTxtf.setLocation(xloc , yloc);
        serverAddressTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        serverPortNumLabel.setLocation(xloc , yloc);
        serverPortNumLabel.setSize(120,dy);
        xloc = xloc + 120 + dx ;

        serverPortNumTxtf.setLocation(xloc , yloc);
        serverPortNumTxtf.setSize(100,dy);
        xloc = xloc + 100 + dx ;

        connectToServerBtn.setLocation(xloc, yloc);
        connectToServerBtn.setSize(150, dy);
        xloc = xloc + 150 + dx ;

        xloc = space ;
        yloc = yloc + dy + space + space;

        add(servarAddressLabel);
        add(serverAddressTxtf);
        add(serverPortNumLabel);
        add(serverPortNumTxtf);
        add(connectToServerBtn);

        //*****************************************************************************
        //*****************************************************************************
        //***************************Crypto********************************************
        //row 5
        part3Header.setForeground(Color.red);
        part3Header.setLocation(300, yloc);
        part3Header.setSize(300, dy);
        add(part3Header);

        xloc = space ;
        yloc = yloc + dy + space + space;
        getPlainText.setLocation(xloc, yloc);
        getPlainText.setSize(150, dy);
        xloc = xloc + 150 + dx ;
        add(getPlainText);
        loadInputTxtf.setLocation(xloc, yloc);
        loadInputTxtf.setSize(150, dy);
        xloc = xloc + 150 + dx ;
        add(loadInputTxtf);


        xloc = space ;
        yloc = yloc + dy + space + space;

        //row 6
        runPSPP.setLocation(xloc, yloc);
        runPSPP.setSize(150, dy);
        runPSPP.setEnabled(false);
        xloc = xloc + 150 + dx + dx ;

        scalarProductResultArea.setLocation(xloc, yloc);
        scalarProductResultArea.setSize(200, 100);
        scalarProductResultArea.setEditable(false);
        add(runPSPP);
        add(scalarProductResultArea);
        xloc = space ;
        yloc = yloc + dy + dy + dy + dy;

        //*****************************************************************************
        //*****************************************************************************
        //***************************CLASSIFICATON******************************
        //row 7
        part4Header.setForeground(Color.red);
        part4Header.setLocation(300, yloc);
        part4Header.setSize(200, dy);
        add(part4Header);
        thresholdLabel.setLocation(xloc, yloc);
        thresholdLabel.setSize(100, dy);
        xloc = xloc + 100 + dx + dx ;
        add(thresholdLabel);

        thresholdTxtf.setLocation(xloc, yloc);
        thresholdTxtf.setSize(50, dy);
        xloc = xloc + 50 + dx ;
        add(thresholdTxtf);
        xloc = space ;
        yloc = yloc + dy + space;

        //row 8

        classificationBtn.setLocation(270, yloc);
        classificationBtn.setSize(250, dy);
        xloc = xloc + 250 + dx  ;
        classificationBtn.setEnabled(false);
        add(classificationBtn);
        xloc = space ;
        yloc = yloc + dy + space;


        //row 9
        trainDatasetSizelabel.setLocation(xloc, yloc);
        trainDatasetSizelabel.setSize(150, dy);
        xloc = xloc + 150 + dx  ;
        add(trainDatasetSizelabel);

        trainDatasetSizeTxtf.setLocation(xloc, yloc);
        trainDatasetSizeTxtf.setSize(40, dy);
        xloc = xloc + 40 + dx  ;
        add(trainDatasetSizeTxtf);

        testDataSetSizelabel.setLocation(xloc, yloc);
        testDataSetSizelabel.setSize(150, dy);
        xloc = xloc + 150 + dx  ;
        add(testDataSetSizelabel);

        testDataSetSizeTxtf.setLocation(xloc, yloc);
        testDataSetSizeTxtf.setSize(40, dy);
        xloc = xloc + 40 + dx  ;
        add(testDataSetSizeTxtf);

        errorRatelabel.setLocation(xloc, yloc);
        errorRatelabel.setSize(100, dy);
        xloc = xloc + 100 + dx  ;
        add(errorRatelabel);

        errorRateTxtf.setLocation(xloc, yloc);
        errorRateTxtf.setSize(200, dy);
        xloc = xloc + 200 + dx  ;
        add(errorRateTxtf);



        //****************************************************************************************
        //****************************************************************************************
        //*************************************Event Handler**************************************
        //****************************************************************************************
        formHandler handler = new formHandler();
        generateKeyBtm.addActionListener(handler);
        connectToServerBtn.addActionListener(handler);
        getPlainText.addActionListener(handler);
        runPSPP.addActionListener(handler);
        runPSPP.addActionListener(handler);
        classificationBtn.addActionListener(handler);

    }

    public class formHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {

            //**************************************************************
            //**************************************************************
            //*************************Generate Key Button******************


            if(event.getSource() == generateKeyBtm)
            {
                bitLength = Integer.parseInt(bitLengthTxtf.getText());
                PaillierCryptoSystem paillier = new PaillierCryptoSystem(bitLength, 64);
                pNum = paillier.p.toString();
                qNum = paillier.q.toString();
                nNum = paillier.n.toString();
                gNum = paillier.g.toString();
                lamdaNum = paillier.lambda.toString();
                uNum = paillier.u.toString();

                n = paillier.n;
                g = paillier.g;
                lambda = paillier.lambda;
                u = paillier.u;

                pTxtf.setText(pNum);
                qTxtf.setText(qNum);
                nTxtf.setText(nNum);
                gTxtf.setText(gNum);
                lambdaTxtf.setText(lamdaNum);
                uTxtf.setText(uNum);

            }
            else if(event.getSource() == connectToServerBtn)
            {
                try
                {
                    serverAddress = serverAddressTxtf.getText();
                    serverPortNumber = Integer.parseInt(serverPortNumTxtf.getText());
                    connectToServer();
                    colSign1 = Integer.parseInt(in.readLine());
                    colSign2 = Integer.parseInt(in.readLine());
                    JOptionPane.showMessageDialog(null, "You Are Now Connected To Server Bob!","Connection Status" , JOptionPane.PLAIN_MESSAGE);
                }
                catch (IOException e)
                {
                    JOptionPane.showMessageDialog(null, "You Are Not Connected To Server Bob!","Connection Status" , JOptionPane.PLAIN_MESSAGE);

                    e.printStackTrace();
                }
            }
            else if(event.getSource() == getPlainText)
            {
                try
                {
                    readFilePlainText("E:\\Sattarzadeh\\Codes\\github\\neural-network-project\\PPNN\\AliceServer\\src\\main\\java\\org\\example\\alice\\operation\\files\\plainText.txt");
                }
                catch (IOException e)
                {
                    System.out.println("file plainText.txt does not exists!");
                    e.printStackTrace();
                }
                runPSPP.setEnabled(true);

            }
            else if(event.getSource() == runPSPP)
            {
                scalarProductResultArea.setText("PSPP is running...");
                scalarProductResultArea.append("\n");
                scalarProductResultArea.append("it might take a few seconds.");
                scalarProductResultArea.append("\n");

                outputArrayList = new ArrayList<String>();
                devideparameter = new BigInteger("100000");

                //   		 thresholdValue = Double.parseDouble(thresholdTxtf.getText());
                // System.out.println(thresholdValue);
                for (int i = 0; i < inputArrayList.size(); i++)
                {
                    seperatePlainTexts(inputArrayList.get(i));
                    //System.out.println("\n");
                    PaillierCryptoSystem paillier = new PaillierCryptoSystem(bitLength, n, g, lambda, u);
                    if (colSign1 == 1 && colSign2 == 1)
                    {
                        cipherText1 = paillier.Encryption(plainTextBigIntPart1);
                        cipherText2 = paillier.Encryption(plainTextBigIntPart2);

                    }
                    else if (colSign1 == 1 && colSign2 == -1)
                    {
                        cipherText1 = paillier.Encryption(plainTextBigIntPart1);
                        cipherText2 = paillier.NEncryption(plainTextBigIntPart2);

                    }
                    else if (colSign1 == -1 && colSign2 == 1)
                    {
                        cipherText1 = paillier.NEncryption(plainTextBigIntPart1);
                        cipherText2 = paillier.Encryption(plainTextBigIntPart2);

                    }
                    else if (colSign1 == -1 && colSign2 == -1)
                    {
                        cipherText1 = paillier.NEncryption(plainTextBigIntPart1);
                        cipherText2 = paillier.NEncryption(plainTextBigIntPart2);

                    }
                    out.println(cipherText1.toString());
                    out.println(cipherText2.toString());
                    out.println(paillier.nsquare.toString());
                    try
                    {
                        w = new BigInteger(in.readLine());
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }

                    z = paillier.Decryption(w);
                    devideParameterStr = z.toString();
                    zDouble = Double.parseDouble(devideParameterStr);
                    String compareStr = paillier.n.subtract(z).toString();
                    double compareDouble = Double.parseDouble(compareStr);
                    if(compareDouble < zDouble)
                    {
                        BigInteger manfi = new BigInteger("-1");
                        z = paillier.n.subtract(z);
                        z = z.multiply(manfi);
                        //	 System.out.println(z.toString());
                    }
                    devideParameterStr = z.toString();
                    zDouble = Double.parseDouble(devideParameterStr);

                    zDouble = zDouble / 100000;
//				     System.out.println(zDouble);
                    zDoubleStr = Double.toString(zDouble);
                    // scalarProductResultArea.setText(z.toString());
                    scalarProductResultArea.append(zDoubleStr);
                    scalarProductResultArea.append("\n");
                    outputArrayList.add(zDoubleStr);
//		     		 writeScalarProductResult(outputArrayList, "dotproductResult.txt");
                }
                classificationBtn.setEnabled(true);
            }
            else if(event.getSource() == classificationBtn)
            {
                System.out.println("Compare result");

                try
                {
                    thresholdFunction();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                try
                {
                    compareResults();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }





    }



    public void connectToServer() throws IOException
    {

// Make connection and initialize streams
        socket = new Socket(serverAddress, serverPortNumber);

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

    }

    void readFilePlainText(String fileName) throws IOException
    {
        inputArrayList = new ArrayList<String>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            br.readLine();// plain text
            while ((line = br.readLine()) != null)
            {
                inputArrayList.add(line);
            }


        }
        finally
        {
            br.close();
        }
    }
    void seperatePlainTexts(String line)
    {
        percent = 1000;
        String[] ar = line.split(",");
        plainTextPart1 = Double.parseDouble(ar[0]);
        plainTextPart2 = Double.parseDouble(ar[1]);
// converting double to integer
        plainTextPart1Int = (int) (plainTextPart1 * percent);
        plainTextPart2Int = (int) (plainTextPart2 * percent);
        String s1 = Integer.toString(plainTextPart1Int);
        String s2 = Integer.toString(plainTextPart2Int);
        plainTextBigIntPart1 = new BigInteger(s1);
        plainTextBigIntPart2 = new BigInteger(s2);

    }
    public void thresholdFunction() throws IOException
    {
        outputArrayListDouble = new ArrayList<Double>();
        testlabelArrayList = new ArrayList<Integer>();
        testlabelArrayListStr = new ArrayList<String>();

        System.out.println("inja");
        for(int i = 0; i < outputArrayList.size(); i++)
        {
            outputArrayListDouble.add(i, Double.parseDouble(outputArrayList.get(i)));
        }



        for(int i = 0; i < outputArrayListDouble.size(); i++)
        {
            if(outputArrayListDouble.get(i) >= thresholdValue)
            {
                testlabelArrayList.add(1);
                testlabelArrayListStr.add("1");
            }
            else
            {
                testlabelArrayList.add(0);
                testlabelArrayListStr.add("0");
            }
            writeScalarProductResult(testlabelArrayListStr, "E:\\Sattarzadeh\\Codes\\github\\neural-network-project\\PPNN\\AliceServer\\src\\main\\java\\org\\example\\TestLabels.txt");
        }
    }
    void writeScalarProductResult(ArrayList<String> arrayList, String fileName)
    {
        try
        {
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);
            for (int i = 0; i < arrayList.size(); i++)
            {
                bufferedWriter.write(arrayList.get(i));
                bufferedWriter.newLine();

            }
            bufferedWriter.close();	}
        catch( IOException e )
        {
            System.out.println("Error: " + e);
            e.printStackTrace( );
        }
    }

    public void compareResults() throws IOException
    {
        readFileTestActualLabel("E:\\Sattarzadeh\\Codes\\github\\neural-network-project\\PPNN\\AliceServer\\src\\main\\java\\org\\example\\alice\\operation\\files\\ActualLabel.txt");
        counter = 0;


        for(int i = 0; i < testlabelArrayList.size(); i++)
        {
            if(testlabelArrayList.get(i) != testActualLabelArrayList.get(i))
            {
                counter++;
            }
        }
        System.out.println(counter);
        System.out.println(testlabelArrayList.size());

        double darsad = ((double)counter/(double)(testActualLabelArrayList.size())) * 100;
        System.out.println(darsad);
        errorRateTxtf.setText(Double.toString(darsad)+"%");
    }

    void readFileTestActualLabel(String fileName) throws IOException
    {

        testActualLabelArrayList = new ArrayList<Integer>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            while ((line = br.readLine()) != null)
            {
                testActualLabelArrayList.add(Integer.parseInt(line));
            }

        }
        finally
        {
            br.close();
        }
    }


    public static void main( String[] args )
    {
        PPNNForm mainForm = new  PPNNForm();
        mainForm.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE);
        mainForm.setSize(820, 720);
        mainForm.setVisible(true);
    }
}

