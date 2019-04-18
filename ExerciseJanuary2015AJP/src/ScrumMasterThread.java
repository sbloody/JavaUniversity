
public class ScrumMasterThread implements Runnable
{
   private PizzaMethods master;
   
   public ScrumMasterThread(PizzaMethods master)
   {
      this.master=master;
   }
   
   public void run()
   {
      while(true)
      {
         master.orderAPizza();
         activities();
      }
   }
   
   private void activities()
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
