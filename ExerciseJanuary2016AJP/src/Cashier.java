
public class Cashier implements Runnable
{
   private SuperMarket monitor;

   public Cashier(SuperMarket monitor)
   {
      this.monitor = monitor;
   }

   public void run()
   {
    while (true)
     
      {
         prepare();
         monitor.startNextServing();
         serving();
         monitor.serviceFinished();

      }
   }

   private void prepare()
   {

      try
      {
         Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {

      }
   }

   private void serving()
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
