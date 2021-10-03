package FileTransfer.Client;

import java.io.*;
import java.net.*;

public class ClientClass {
	public static void main(String argv[]) throws IOException,FileNotFoundException {
        //create the socket
        Socket socketClient = new Socket("localhost",8888);
        System.out.println("Client: Connection Established");

        
        String fileName = "./test.txt";
        
        try(InputStream input = new FileInputStream(fileName)){
            //outputStream used to send data to the serverSocket
            OutputStream output = socketClient.getOutputStream();
            //variable used to know when the FileInputStream has no more bytes to read
            int i = 0;

             do {
                //array of bytes to read the data in chunks of 1024 bytes
                byte[] data = new byte[1024];
                //read and save the data, and return the total number of bytes read into the byte array
                i = input.read(data);
                //send the read data to the serverSocket (outputStream)
                output.write(data);
                // String value = new String(data,StandardCharsets.UTF_8);
                // System.out.print(value);

            //i only will be -1 when .read() has no more bytes to read from the FileInputStream
             }while(i != -1);

             //close Streams and socket
             output.close();
             input.close();
             socketClient.close();
        }
        

	}
}
