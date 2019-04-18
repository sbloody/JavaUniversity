import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class RemoteMessageClient extends UnicastRemoteObject implements Serializable, ReplyTo 
{
   private RemoteMessageList server;

   public static void main(String[] args) throws Exception
   {
      RemoteMessageClient client=new RemoteMessageClient();
   }
   
   public RemoteMessageClient() throws RemoteException
   {
      super();
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Enter a message:");
      String str = keyboard.nextLine();
      try{
         server=(RemoteMessageList) Naming.lookup("rmi://localhost:1099/addMessage");
         
            server.addMessage(str,this);
            
            
        
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void replyMessage(String msg)
   {
      System.out.println(msg);
      
   }

}
