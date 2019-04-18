package task3;

public class Customer implements Runnable
{
   private BarDesk monitor;

   public Customer(BarDesk monitor)
   {
      this.monitor=monitor;
   }
   @Override
   public void run()
   {
      for(int i=0;i<10;i++)
      {
         walkToTheBar();
         monitor.takeFullGlasses();
         drink();
         monitor.placeEmptyGlasses();
      }
      
   }
   
   private void walkToTheBar()
   {
      
      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {

      }
   }
   
   private void drink()
   {
      
      try
      {
         Thread.sleep(2000);
      }
      catch (InterruptedException e)
      {

      }
   }
}
