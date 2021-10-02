package FileTransfer.Server;

import java.io.*;
import java.net.*;

public class ServerClass {
	public static void main(String[] args) throws IOException {
		System.out.println("Server is running");
        //create serverSocket and accept incoming connections
        ServerSocket socketServer = new ServerSocket(8888);
        Socket socket = socketServer.accept();

        //obtain the input from the clientSocket
        InputStream input = socket.getInputStream();

        //location of the file to create
        String fileName = "C:\\Llaves\\test2.txt";
        //FileOutputStream used to create the text file and write the data from the socket client in it
        OutputStream output = new FileOutputStream(fileName);

        //variable used to know when the FileInputStream has no more bytes to read
        int i = 0;
        do{
            //array of bytes to read the data in chunks of 1024 bytes
            byte[] data = new byte[1024];
            //read and save the data, and return the total number of bytes read into the byte array
            i = input.read(data);
            //write the data to the FileOutputStream (the text file). It takes the array of bytes as the data to write, the offset is 0, and i as the length of the byte array
            output.write(data, 0, i);
        //i only will be -1 when .read() has no more bytes to read from the FileInputStream
        }while(i != -1);

        //close streams and sockets
        input.close();
        output.close();
        socket.close();
        socketServer.close();
	}
}
