**Privacy-Preserving Neural Network**



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
![image](https://github.com/user-attachments/assets/7e2adf58-b0d6-4689-993f-d460fbca82a9)

 
**Cryprosystem**

The type of encryption used in this protocol is the Paillier Cryptosystem, which has properties of homomorphism and randomness. 
It is a form of encryption in which an algebraic operation can be performed on the ciphertext to yield the result of another algebraic operation on the original plaintext.

  **Step 1: Key Pair Generation By ALice**

  ![image](https://github.com/user-attachments/assets/9bb3a28d-1614-4b82-a837-b2da0adeb773)


  **Step 2: Run Bob Server**
  ![image](https://github.com/user-attachments/assets/f215afc6-2bc3-4bc6-8248-dfc4a9192b2a)

  **Step 3: Stabilishing Alice And Bob Connection**
  ![image](https://github.com/user-attachments/assets/d96c302a-104b-44cc-bdb4-f8304c04908c)
  
  **Step 4: Load Input Data And Run PSPP(Private Scalar Product Protocol) And Classify Results**
  ![image](https://github.com/user-attachments/assets/4cd978f5-f5b8-4118-8adf-d55eb175a5ba)

  


  

