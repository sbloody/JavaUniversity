package task3;

public class Bartender implements Runnable
{
   private BarDesk monitor;
   
   public Bartender(BarDesk monitor)
   {
      this.monitor=monitor;
   }
   @Override
   public void run()
   {
      while(true)
      {
         monitor.takeEmptyGlasses();
         cleanAndFill();
         monitor.placeFullGlasses();
         
         
      }


   }   
   
   private void cleanAndFill()
   {
      
      try
      {
         Thread.sleep(3000);
      }
      catch (InterruptedException e)
      {

      }
   }
   
  

}
