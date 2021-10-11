
import java.io.*;
import java.net.*;
import java.util.HashSet;

public class Server {



    // set of all BufferedWriters for all the connected clients. Used to broadcast
    // messages
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();

    public static void main(String argv[]) {
        System.out.println(" Server is Running ");

        ServerSocket server = null;

        try {
            // server listening on port 5555
            server = new ServerSocket(5555);

            while (true) {
                new Handler(server.accept()).start();
                System.out.println("New client connected");


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (server != null) {
                try {
                    System.out.println("Server closing");
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // create a handler to spawn the clients as different threads. This handlers are
    // responsible
    // for dealing with a single client and broadcasting its messages
    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader reader;
        private PrintWriter writer;

        // constructor the handler thread
        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // create the reading and writing streams
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                writer = new PrintWriter(socket.getOutputStream(),true);

                //add the writer to the PrintWriters set
                writers.add(writer);

                // accept messages from the client and broadcast them
                String data;
                while ((data = reader.readLine()) != null) {
                    for(PrintWriter w : writers){
                        w.println(data);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if(writer != null){
                    writers.remove(writer);
                }
                try {
                    socket.close();
                } catch (Exception e) {
                }
            }
        }
    }

}

