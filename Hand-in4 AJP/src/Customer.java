
public class Customer implements Runnable
{
   private TakeANumber dispenser;
   
   public Customer(TakeANumber dispenser)
   {
      this.dispenser=dispenser;
   }
   
   @Override
   public void run() 
   {
               
      arrival(2000,5000);
      dispenser.takeNextNumber();      
   }

   private void arrival(int min, int max)
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

