import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RemoteTaskList extends Remote
{
   void add(String task) throws RemoteException;
   void remove() throws RemoteException;
   int size() throws RemoteException;
}
