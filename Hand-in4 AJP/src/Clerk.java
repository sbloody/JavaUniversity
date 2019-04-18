public class Clerk implements Runnable
{

   private TakeANumber dispenser;

   public Clerk(TakeANumber dispenser)
   {
      this.dispenser = dispenser;
   }

   @Override
   public void run()
   {
      while (true)
      {
         int ticket = dispenser.nextCustomer();
         System.out.println(Thread.currentThread().getName() + " is still serving number " + ticket);
         serve(8000, 10000);
         System.out.println(Thread.currentThread().getName() + " finished serving number " + ticket);
      }
   }

   private void serve(int min, int max)
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
