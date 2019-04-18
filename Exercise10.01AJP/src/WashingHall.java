public class WashingHall
{
   private QueueADT<Hall> availableHalls;
   private int occupiedHalls;
//   private int numberOfWashingHalls;
//   private Hall hall;
   

   public WashingHall(int numberOfWashingHalls)
   {
      this.availableHalls=new LinkedQueue<Hall>();
      for(int i=0;i<numberOfWashingHalls;i++)
      {
         Hall hall=new Hall(numberOfWashingHalls);
         availableHalls.enqueue(hall);
      }
      
   }

   public synchronized Hall enterForWashing()
   {
      while(availableHalls.isEmpty())
      {
         try
         {
            System.out
            .println(Thread.currentThread().getName() + " is waiting");
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      Hall hall=availableHalls.dequeue();
      occupiedHalls++;
      notifyAll();
      System.out.println("--->" +Thread.currentThread().getName()
            + " is being washed - occupied=" + occupiedHalls);
      return hall;
      
        
   }

   public synchronized void leaveWashing(Hall hall)
   {
      availableHalls.enqueue(hall);
      occupiedHalls--;
      notifyAll();
      System.out.println("<---"+Thread.currentThread().getName()
            + " is finished being washed - occupied=" + occupiedHalls);
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
      return availableHalls.size() - occupiedHalls;
   }
}
