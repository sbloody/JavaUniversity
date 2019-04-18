import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class TaskClient
{
   private RemoteTaskList server;

   public TaskClient() throws RemoteException
   {
      super();

      try
      {
         server = (RemoteTaskList) Naming.lookup("rmi://localhost:1099/Task");
      }
      catch (MalformedURLException e)
      {
         e.printStackTrace();
      }
      catch (NotBoundException e)
      {
         e.printStackTrace();
      }

      Scanner keyboard = new Scanner(System.in);
      while (true)
      {

         System.out.println("Do you want to add, remove or see the size? ");
         String str = keyboard.nextLine();

         if (str.equalsIgnoreCase("add"))
         {
            String task = keyboard.nextLine();
            server.add(task);
         }
         else if (str.equalsIgnoreCase("remove"))
         {
            server.remove();
         }
         else if (str.equalsIgnoreCase("size"))
         {

            System.out.println("size = " + server.size());
         }
         else if (str.equalsIgnoreCase("exit"))
         {
            System.exit(0);
         }
      }

      // /PREVIOUS EXERCISE!!!!!!!!!!!!!!!!!!!!!
      // server.add("Hello");
      // System.out.println("Task was addded ");

   }

   public static void main(String[] args) throws RemoteException
   {
      TaskClient client = new TaskClient();
   }

}