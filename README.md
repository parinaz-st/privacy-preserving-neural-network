**Privacy-Preserving Neural Network**



This repository provides a partial re-implementation of the protocol outlined in the paper "A Privacy-Preserving Protocol for Neural-Network-Based Computation". You can find the original paper here: 

https://dl.acm.org/doi/10.1145/1161366.1161393

**Overview**

This project implements privacy-preserving techniques for neural networks, enabling secure interaction between a model owner (Bob) and a data owner (Alice).
Bob manages the neural network (NN), while Alice can send her encrypted data to the NN and receive results without exposing her sensitive information or gaining any knowledge of the NN weights.



From the server's perspective, the neural network operates on the encrypted input, which it cannot decrypt.
The goal is to perform these computations in a privacy-preserving manner. This approach is based on this perspectives:

-__Perspective__: The input data and weights of the neural network are encrypted.

  In this level, the client sends encrypted data to the server. The server processes the data without decrypting it.
  The data and the weights of the neural network are kept confidential throughout the computation. 
  The first security level guarantees that the neural network processes the data in an encrypted format, without revealing sensitive information



  **Step 1: Key Pair Generation By ALice**

  ![image](https://github.com/user-attachments/assets/9bb3a28d-1614-4b82-a837-b2da0adeb773)



  

