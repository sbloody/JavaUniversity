import java.rmi.RemoteException;
import java.util.Observable;

import utility.observer.*;

public class BusPassenger implements RemoteObserver
{
   private String name;
   private Bus bus;
   private boolean newPassenger;

   public BusPassenger(String name)
   {
      this.name = name;
      this.bus = null;
      this.newPassenger = false;
   }

   // some methods not shown...

   public void getIn(Bus bus)
   {
      if (this.bus != null)
         getOut();
      this.bus = bus;
      newPassenger = true;
      bus.passengerGettingIn(this);
   }

   public void getOut()
   {
      newPassenger = false;
      bus.passengerGettingOut(this);
      bus = null;
   }

   public void update(Observable o, Object arg)
   {
      String message = arg.toString();
      String reply = "";
      String[] split = message.split(":");
      if (split.length != 2)
      {
         reply = "I don't understand";
      }
      else
      {
         if (split[0].equalsIgnoreCase("Enter"))
            reply = "Hello ";
         else
            reply = "Bye Bye ";
         reply += split[1];
      }
      System.out.println(name + "> " + reply);
   }

   public boolean isNewPassenger()
   {
      return this.newPassenger;
   }

   public Bus getBus()
   {
      return this.bus;
   }

   public String getName()
   {
      return this.name;

   }

   public String toString()
   {
      return name;
   }

   public boolean equals(Object obj)
   {
      if (!(obj instanceof BusPassenger))
         return false;
      BusPassenger p = (BusPassenger) obj;
      return name.equals(p.name)
            && ((bus == null & p.bus == null) || bus.equals(p.bus))
            && newPassenger == p.newPassenger;
   }

   @Override
   public void update(RemoteSubject arg0, Object arg1) throws RemoteException
   {
      System.out.println();
      
   }

   

   

}