import java.util.Observable;

public class Bus extends Observable
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
      
      super.setChanged();
      super.notifyObservers("Enter:" + p.getName());
      super.addObserver(p);
   }
   public void passengerGettingOut(BusPassenger p)
   {
      
      super.deleteObserver(p);
      super.setChanged();
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