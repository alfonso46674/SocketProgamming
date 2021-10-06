package FileTransfer.Client;

import java.io.*;
import java.net.*;

public class FTPClientClass {
    public static void main(String argv[]) {

        try {

            // create the socket
            Socket socketClient = new Socket("localhost", 8888);
            System.out.println("Client: Connection Established");

            // InputStream input = new FileInputStream(fileName)
            String fileName = "./test.txt";

            // create the input as a bufferedReader that will hold a reference to the file
            // to read as a FileInputStream
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

            // BufferedWriter used to send data to the serverSocket
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream())); // socketClient.getOutputStream();

            // variable used to hold the data from the file
            String data;

            // read data from the file until there is no more to read
            while ((data = input.readLine()) != null) {
                // write the data to the output of the socket with \r\n so it has a line break
                output.write(data + "\r\n");
            }

            // close Streams and socket
            output.close();
            input.close();
            socketClient.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
