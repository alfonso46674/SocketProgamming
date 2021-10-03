
import java.io.*;
import java.net.*;

/**
 *
 * @author macbookpro
 */
public class Server implements Runnable{
    private Socket clientSocket;
    //constructor
    public Server(Socket s){
        this.clientSocket = s;
    }

    //run function for each thread
    public void run(){
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter writer;
            writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            writer.write("*** Welcome to the Calculation Server (Addition Only) ***\r\n");
            writer.write("*** Please type in the first number and press Enter : \n");
            writer.flush();
            String data1 = reader.readLine().trim();
            writer.write("*** Please type in the second number and press Enter :\n");
            writer.flush();
            String data2 = reader.readLine().trim();
            int num1 = Integer.parseInt(data1);
            int num2 = Integer.parseInt(data2);
            int result = num1 + num2;
            System.out.println("Addition operation done ");
            writer.write("\r\n=== Result is : \n" + result + "\n");
            writer.flush();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String argv[]){
        System.out.println(" Server is Running ");

        ServerSocket server = null;

        try{
            //server listening on port 5555
            server = new ServerSocket(5555);

            while(true){
                //socket object to receive incoming client requests
                Socket client = server.accept();
    
                System.out.println("New client connected");
                
                //create the new thread along with the Server object
                Thread serverThread = new Thread(new Server(client));
                serverThread.start();

    
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(server != null){
                try{
                    server.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }

    }
}
