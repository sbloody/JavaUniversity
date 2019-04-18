package chat.domain.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
   public static void main(String args[]) throws IOException,
         UnknownHostException, ClassNotFoundException
   {
      final int PORT = 2910;
      final String HOST = "10.52.236.216";
      // create client socket, connect to server.
      Socket clientSocket = new Socket(HOST, PORT);
      System.out.println("Client> connected to server");
      // create output stream attached to the socket.
      ObjectOutputStream outToServer = new ObjectOutputStream(
            clientSocket.getOutputStream());
      // create input stream attached to the socket.
      ObjectInputStream inFromServer = new ObjectInputStream(
            clientSocket.getInputStream());
      // Read line from keyboard.
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Write a line for the server: ");
      String inputLine = keyboard.nextLine();
      keyboard.close();
      // Send message to server
      Message message = new Message(inputLine);
      System.out.println("Client> " + message);
      outToServer.writeObject(message);
      // Read message from Server.
      Message replyMessage = (Message) inFromServer.readObject();
      System.out.println("Server> " + replyMessage);
      // Close connection.
      clientSocket.close();
   }
}