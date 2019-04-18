public class PassportController implements Runnable
{
   private AirportQueue queue;
   private LinkedQueue<Passenger> checkQueue;
   private String nationality;

   public PassportController(AirportQueue queue, String nationality)
   {
      this.queue = queue;
      this.nationality = nationality;
      checkQueue = new LinkedQueue<Passenger>();

   }

   @Override
   public void run()
   {
      Passenger p;
      while (true)
      {

         if (nationality.equals("US"))
         {
            checkQueue = queue.getUS();
            p = queue.getNextPassengerUS();
         }
         else
         {
            checkQueue = queue.getNonUS();
            p = queue.getNextPassengerNonUS();
         }
         control(1000, 3000);
         if (p.getPassportNumber() > 0)
         {
            System.out.println("Passport number: " + p.getPassportNumber()
                  + " has been checked");
         }
         
         else{
            System.out.println("Passport number invalid");
            
         }

      }

   }

   private void control(int min, int max)
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

}
