import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class TaskServer extends UnicastRemoteObject implements RemoteTaskList
{

   private TaskList list;

   public TaskServer() throws RemoteException
   {
      super();
      this.list = new TaskList();
   }

   @Override
   public void add(String task) throws RemoteException
   {
      list.addTask(task);
      System.out.println("The task is: " + task);
   }

   @Override
   public void remove() throws RemoteException
   {
      System.out.println("Removing a task " + list.getAndRemoveNextTask());
   }

   @Override
   public int size() throws RemoteException
   {
      return list.size();
   }

   public static void main(String[] args)
   {
      try
      {
         Registry reg = LocateRegistry.createRegistry(1099);
         RemoteTaskList rmiServer = new TaskServer();
         Naming.rebind("Task", rmiServer);
         System.out.println("Starting server...");
      }
      catch (RemoteException | MalformedURLException e)
      {
         e.printStackTrace();
      }

   }
}