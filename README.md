**Privacy-Preserving Neural Network - Course Project Jul.2016**



This repository provides a partial re-implementation of the protocol outlined in the paper "A Privacy-Preserving Protocol for Neural-Network-Based Computation". You can find the original paper here: 

https://dl.acm.org/doi/10.1145/1161366.1161393

**Overview**

This project implements privacy-preserving techniques for neural networks, enabling secure interaction between a model owner (Bob) and a data owner (Alice).
Bob manages the neural network (NN), while Alice can send her encrypted data to the NN and receive results without exposing her sensitive information or gaining any knowledge of the NN weights.



From the server's perspective, the neural network operates on the encrypted input, which it cannot decrypt.
The goal is to perform these computations in a privacy-preserving manner.

**Input Data**

The protocol implemented is for a single-layer perceptron neural network, which only has the capability to classify linearly separable data. 
For this implementation, a linearly separable dataset was first generated and then trained using the neural network.
![image](https://github.com/user-attachments/assets/bc68e654-542b-499c-b39a-f17e774425dc)


 
**Cryprosystem**

The type of encryption used in this protocol is the Paillier Cryptosystem, which has properties of homomorphism and randomness. 
It is a form of encryption in which an algebraic operation can be performed on the ciphertext to yield the result of another algebraic operation on the original plaintext.

**ActivationFunction**
Activation function: Threshold, which Alice is aware of.
(To implement a scenario where the activation function is also hidden from the client, the millionaires' problem approach can be used—this has not been implemented in the current project.)

**PPNN-Level 1**
![image](https://github.com/user-attachments/assets/75cedaf2-dd59-4d89-bcf3-4c9c8d91044b)


**Private Scalar Product Protocol (PSPP)**
![image](https://github.com/user-attachments/assets/dfc12d88-2ed2-4767-847b-935e490a4ae1)


**Impelimentation Notes**

Based on the level one security protocol in the article, Bob, the owner of the neural network, and Alice, the owner of the input data, act as the client. The network communication between Alice and Bob is established through a socket. Alice sends a connection request to Bob, and if Bob's server is up on the specified port, it assigns a connection to Alice's client, and the communication begins at that moment.

As soon as Bob's server is up, it loads the trained neural network weights. Alice also loads her input from the file Plaintext.txt. At this stage, Alice initiates the internal product computation protocol with Bob by clicking the Run PSPP button. In this step, Alice encrypts her data with her public key and sends it to Bob (thus, no one except Alice, who has the corresponding private key, can decrypt her data!).

Upon receiving Alice's encrypted data, Bob raises it to the power of his weights, thereby calculating their product and sending the result back to Alice. Alice decrypts the value received from Bob and, by clicking the classifyInputDataIn2Classes button, provides the obtained number to the activation function, compares it with the actual class of the data, and calculates the error rate.



  **Step 1: Key Pair Generation By ALice**

  ![image](https://github.com/user-attachments/assets/9bb3a28d-1614-4b82-a837-b2da0adeb773)


  **Step 2: Run Bob Server**
  ![image](https://github.com/user-attachments/assets/f215afc6-2bc3-4bc6-8248-dfc4a9192b2a)

  **Step 3: Stabilishing Alice And Bob Connection**
  ![image](https://github.com/user-attachments/assets/d96c302a-104b-44cc-bdb4-f8304c04908c)
  
  **Step 4: Load Input Data And Run PSPP(Private Scalar Product Protocol) And Classify Results**
  ![image](https://github.com/user-attachments/assets/4cd978f5-f5b8-4118-8adf-d55eb175a5ba)

  


  

