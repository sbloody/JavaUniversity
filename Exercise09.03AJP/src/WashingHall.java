public class WashingHall
{
   private int numberOfWashingHalls;
   private int occupiedWashingHalls;

   public WashingHall(int numberOfWashingHalls)
   {
      this.numberOfWashingHalls = numberOfWashingHalls;
      this.occupiedWashingHalls = 0;
   }

   public synchronized void enterForWashing()
   {
      while (occupiedWashingHalls >= numberOfWashingHalls)
      {
         try
         {
            System.out
                  .println(Thread.currentThread().getName() + " is waiting");
            wait();
         }

         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
      occupiedWashingHalls++;
      System.out.println("--->" +Thread.currentThread().getName()
            + " is being washed - occupied=" + occupiedWashingHalls);
      notifyAll(); // notify display

   }

   public synchronized void leaveWashing()
   {
      occupiedWashingHalls--;
      System.out.println("<---"+Thread.currentThread().getName()
            + " is finished being washed - occupied=" + occupiedWashingHalls);
      notifyAll(); // notify cars(and display)
   }

   public synchronized int getFreePlaces()
   {
      try
      {
         wait();
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
      return numberOfWashingHalls - occupiedWashingHalls;
   }
}
