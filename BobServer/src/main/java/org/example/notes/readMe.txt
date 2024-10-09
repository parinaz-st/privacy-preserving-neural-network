Summary of Refactoring:
MainBobApp now handles only the GUI-related logic.
ButtonActionListener takes care of the button click events.
ServerManager manages starting and stopping the server.
ClientHandler handles client-server communication.
WeightCalculator handles all the weight and scalar product computations.

The ServerManager class manages the server and ensures it runs in a separate thread, allowing it to handle multiple clients.
Each client connection is handled in its own ClientHandler thread.
Socket management (closing sockets and managing streams) has been improved to avoid potential blocking or resource leaks.