public class CounterIncrementer implements Runnable
{
   private int updates;
   private Counter counter;

   public CounterIncrementer(Counter counter, int updates)
   {
      this.updates = updates;
      this.counter = counter;
   }

   public void run()
   {
      for (int i = 0; i < updates; i++)
      {

         counter.increment();
         try
         {
            Thread.sleep(1000); // sleep for 1000 milliseconds
         }
         catch (InterruptedException e)
         {
            // do nothing
         }
         
      }
      System.out.println(counter.getValue());
     

   }

}
