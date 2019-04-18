
public class Customer implements Runnable
{
   private SuperMarket monitor;
   
   public Customer(SuperMarket monitor)
   {
      this.monitor=monitor;
   }
   
   @Override
   public void run()
   {
      for(int i=0;i<1;i++)
      {
      arrival();
      monitor.enterWaitingLine();
      leaving();
      }
      
   }
   
   private void arrival()
   {
      
      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {

      }
   }
   
   
   private void leaving()
   {
      
      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {

      }
   }
}
