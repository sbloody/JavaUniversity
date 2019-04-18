import java.rmi.RemoteException;

import utility.observer.AbstractRemoteSubject;


public class Bus extends AbstractRemoteSubject
{
   private String id;
   private BusPassenger p;
   
   public Bus()
   {
      
      this.id = "eXpress " + hashCode() % 100;
   }
// some methods not shown...

   public void passengerGettingIn(BusPassenger p)
   {
      
        
      super.notifyObservers("Enter:" + p.getName());
      try
      {
         super.addObserver(p);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   public void passengerGettingOut(BusPassenger p)
   {
      
      try
      {
         super.deleteObserver(p);
      }
      catch (RemoteException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      super.notifyObservers("Leave:" + p.getName());
   } 
   
   public String getId()
   {
      return this.id;
   }
   
   public BusPassenger getPassengerList()
   {
      return p;
   }
   
   public String toString()
   {
      return getId()+ ":\n"+ getPassengerList();
   }
   
}