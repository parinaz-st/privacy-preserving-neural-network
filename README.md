**Privacy-Preserving Neural Network**

**Overview**

This repository is a re-implementation of the paper "__A privacy-preserving protocol for neural-network-based computation__" ,

https://dl.acm.org/doi/10.1145/1161366.1161393

discusses the problem of securely processing data using neural networks (specifically, single-layer perceptrons).
The neural network processes sensitive data provided by a client (such as financial data),
without revealing any information about the input data or the internal structure of the neural network.

From the server's perspective, the neural network operates on the encrypted input, which it cannot decrypt.
The goal is to perform these computations in a privacy-preserving manner. This approach is based on two perspectives:
*__Perspective 1__: The input data and weights of the neural network are encrypted.

