# Socket programming in Java
The following projects are part of the first assigment for Distributed Architectures and Programming

## 1.Simple server using TCP Sockets

### 1.1 tp_1_socket/Java client and server

In the Client and Server folders inside the tp_1_socket project, there is a simple socket implementation. The server will listen in the local port 5555 for an input from the client. The client will send two numbers that the server will add up and show in the console.

### 1.2 tp_1_socket/Server/Client File Transfer
Inside the tp_1_socket/FileTransfer folder, there are two folders within it: client and server. These two files have the sole function of transmitting a file to one another. The client will read a text file and then transmit it through the socket output, and the server will read the data through the socket input and then create another text file but with the same data as the original text file. Thus, transfering the data from one text file to another.

## 2.Threaded server using TCP Socket
Inside the ThreadedServer folder, there is a multithreaded server capable of handling multiple client connections at the same time. This server is compatible with the java clients from the previous exercise.

## 3. Group chat system using low-level sockets
Inside the GroupChat folder, there is a simple group chat capable of handling multiple clients. The multithreaded server handles the messages sent by a client, and then broadcasts it to the other connected clients.



