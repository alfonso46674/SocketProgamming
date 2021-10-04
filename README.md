## PART 1.3 tp_1_socket/Java client and server

In the Client and Server folders inside the tp_1_socket project, there is a simple socket implementation. The server will listen in the local port 5555 for an input from the client. The client will send two numbers that the server will add up and show in the console.

## PART 1.4 tp_1_socket/Server/Client File Transfer
Inside the tp_1_socket/FileTransfer folder, there are two folders within it: client and server. These two files have the sole function of transmitting a file to one another. The client will read a text file and then transmit it through the socket output, and the server will read the data through the socket input and then create another text file but with the same data as the original text file. Thus, transfering the data from one text file to another.