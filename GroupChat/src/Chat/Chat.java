import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class Chat {
    public JTextField tx;
    public JTextArea ta;
    public String login = "Anonymous";
    PrintWriter writer;
    BufferedReader reader;
    JFrame f = new JFrame("my chat");

    public Chat() {
        // obtain the users name
        login = getName();

        f.setSize(400, 400);

        JPanel p1 = new JPanel();
        p1.setLayout(new BorderLayout());

        JPanel p2 = new JPanel();
        p2.setLayout(new BorderLayout());

        tx = new JTextField();
        p1.add(tx, BorderLayout.CENTER);
        tx.setEditable(false);

        JButton b1 = new JButton("Send");
        p1.add(b1, BorderLayout.EAST);

        ta = new JTextArea();
        ta.setEditable(false);
        p2.add(ta, BorderLayout.CENTER);
        p2.add(p1, BorderLayout.SOUTH);

        f.setContentPane(p2);

        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                //append the users name to the message
                String message = login + " : " + tx.getText();
                writer.println(message);
                tx.setText("");
            }
        });

        f.setVisible(true);
    }

    // prompts for the user's name and returns it as a string
    private String getName() {
        return JOptionPane.showInputDialog(f, "Choose a screen name:", "Screen name selection",
                JOptionPane.PLAIN_MESSAGE);
    }

private void start() {
    try {
        Socket socketClient = new Socket("localhost",5555);
        writer = new PrintWriter(socketClient.getOutputStream(),true);
         reader = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));


         //process all messages from the server
         while(true){
            tx.setEditable(true);
             String data = reader.readLine();
             ta.append(data + "\n");
            }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    public static void main(String[] args) {
        Chat client = new Chat();
        client.start();
    }
}
