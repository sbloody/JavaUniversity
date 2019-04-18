import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RemoteMessageServer extends UnicastRemoteObject implements
      RemoteMessageList
{
   private ArrayList<String> list;
   private ReplyTo reply;

   public RemoteMessageServer() throws Exception
   {
      
      list=new ArrayList<String>();
   }

   public static void main(String[] args)
   {  
      try{
         
         Registry reg=LocateRegistry.createRegistry(1099);
         RemoteMessageServer messageList=new RemoteMessageServer();
         Naming.rebind("addMessage", messageList);
         System.out.println("Starting server...");
         
      }  
      
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }

   @Override
   public void addMessage(String msg,ReplyTo who) throws RemoteException
   {
      list.add(msg);
      this.reply=who;
      System.out.println("Message that is being added is: "+msg);
      reply.replyMessage(msg);

   }  

}
