package FileTransfer.Server;

import java.io.*;
import java.net.*;

public class FTPServerClass {
    public static void main(String[] args) {

        try {

            System.out.println("Server is running");
            // create serverSocket and accept incoming connections
            ServerSocket socketServer = new ServerSocket(8888);
            Socket socket = socketServer.accept();

            // location of the file to create
            String fileName = "test.txt";

            // obtain the input from the clientSocket as a bufferedReader
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // create the output as a bufferedReader that will hold a FileOutputStream to
            // the newe file to create
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));

            // string used to store the data from the client socket
            String data = "";
            // flag used to know if a newLine is needed
            boolean newLine = false;

            // read the input from the client socket until there is no more data
            while ((data = input.readLine()) != null) {
                // condition used to manage the newLines, and to avoid having an unecessary
                // blank line at the end of the file
                if (newLine) {
                    // add new line break
                    output.newLine();
                } else {
                    newLine = true;
                }

                // write data to the file
                output.write(data);
            }

            System.out.println("File transfered correctly");

            // close streams and sockets
            input.close();
            output.close();
            socket.close();
            socketServer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
