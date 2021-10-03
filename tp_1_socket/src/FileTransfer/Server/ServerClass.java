package FileTransfer.Server;

import java.io.*;
import java.net.*;

public class ServerClass {
	public static void main(String[] args) throws IOException {
		System.out.println("Server is running");
        //create serverSocket and accept incoming connections
        try(ServerSocket socketServer = new ServerSocket(8888)){
            Socket socket = socketServer.accept();

            //obtain the input from the clientSocket
            InputStream input = socket.getInputStream();

            //location of the file to create
            String fileName = "test.txt";
            //FileOutputStream used to create the text file and write the data from the socket client in it
            OutputStream output = new FileOutputStream(fileName);

            //variable used to know when the FileInputStream has no more bytes to read
            int i = 0;
            //array of bytes to read the data in chunks of 1024 bytes
            byte[] data = new byte[1024];

            //**Reworked the do while loop into a while loop because there was a out of bounds error, and this way fixed the error and looks less complicated

            //from the socketInput, fill the byte array (data), and assign the total number of trasmitted bytes to i, as long as its greater than 0, continue the reading loop
            while((i = input.read(data)) > 0){
                //write the data to the FileOutputStream (the text file). It takes the array of bytes as the data to write, the offset is 0, and i as the length of the byte array
                output.write(data,0,i);
            }
            //close streams and sockets
            input.close();
            output.close();
            socket.close();
            socketServer.close();
        }
	}
}
