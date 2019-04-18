public class Guide implements Runnable
{
   private QueueADT<Passenger> US;
   private QueueADT<Passenger> NonUs;
   private AirportQueue queue;

   public Guide(AirportQueue queue)
   {
      this.queue =queue;
      US = queue.getUS();
      NonUs = queue.getNonUS();
   }

   public void run()
   {
      queue.putPassengerInQueue(appear("US", 203040));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("UK", 213141));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("US", 223242));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("BG", 233343));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("RO", 243444));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("DK", 253545));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("US", 263646));
      guide(1000, 3000);
      queue.putPassengerInQueue(appear("DE", 273747));
      while (true)
      {
//          System.out.println(Thread.currentThread().getName() + " is guiding "
//          + );

         guide(1000, 3000);
         Passenger p = queue.getNextPassenger();

         if (p.getNationality().equals("us"))
         {
            US.enqueue(p);
            System.out.println("Passenger is going to US citizens queue");
         }
         else
         {
            NonUs.enqueue(p);
            System.out.println("Passenger is going to Non-US citizens queue");
         }
         guide(1000, 3000);

      }

   }

   private void guide(int min, int max)
   {
      int time = (int) (Math.random() * (max - min) + min);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }

   private Passenger appear(String nationality, int passportNumber)
   {

      Passenger p = new Passenger(nationality, passportNumber);
      return p;
      
   }
   
   public QueueADT<Passenger> returnUS()
   {
      return US;
   }
   
   public QueueADT<Passenger> returnNonUS()
   {
      return NonUs;
   }

}
