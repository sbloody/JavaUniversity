
public class CustomerArrivals implements Runnable
{
   
   private BarberShop barber;
   
   public CustomerArrivals(BarberShop barber)
   {
      this.barber = barber;
   }
     
   @Override
   public void run()
   {
      for (int i = 0; i < 5; i++)
      {
         wait(1000, 2000);
         Customer customer = barber.cuttingTheNext();
         cut(500, 1000);
         barber.wantsToBeCut(customer);
         wait(1000, 2000);
      }
   }
   private void wait(int min, int max)
   {
      int time = (int) (Math.random() * (max - min) + min);
      try
      {
         Thread.sleep(time);
         System.out.println("Waiting: ");
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
   private void cut(int min, int max)
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
