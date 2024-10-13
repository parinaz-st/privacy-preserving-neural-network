**Privacy-Preserving Neural Network**



This repository is a re-implementation of the paper "__A privacy-preserving protocol for neural-network-based computation__" ,

https://dl.acm.org/doi/10.1145/1161366.1161393

**Overview**

This project implements privacy-preserving techniques for neural networks, enabling secure interaction between a model owner (Bob) and a data owner (Alice).
Bob manages the neural network (NN), while Alice can send her encrypted data to the NN and receive results without exposing her sensitive information or gaining any knowledge of the NN weights.


discusses the problem of securely processing data using neural networks (specifically, single-layer perceptrons).
The neural network processes sensitive data provided by a client (such as financial data),
without revealing any information about the input data or the internal structure of the neural network.

From the server's perspective, the neural network operates on the encrypted input, which it cannot decrypt.
The goal is to perform these computations in a privacy-preserving manner. This approach is based on two perspectives:

-__Perspective 1__: The input data and weights of the neural network are encrypted.

  In this level, the client sends encrypted data to the server. The server processes the data without decrypting it.
  The data and the weights of the neural network are kept confidential throughout the computation. 
  The first security level guarantees that the neural network processes the data in an encrypted format, without revealing sensitive information

  

