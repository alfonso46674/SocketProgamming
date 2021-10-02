package Client;

import java.io.*;
import java.net.*;

/**
 *
 * @author macbookpro
 */
public class ClientClass {
    public static void main(String argv[]) {
        try {
            Socket socketClient = new Socket("localhost", 5555);
            System.out.println("Client: " + "Connection Established");
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            String serverMsg;
            writer.write("8\r\n");
            writer.write("10\r\n");
            writer.flush();
            while ((serverMsg = reader.readLine()) != null) {
                System.out.println("Client:" + serverMsg);
            }
            socketClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
