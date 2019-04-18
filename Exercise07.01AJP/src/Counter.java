public class Counter
{
   private long value;
   private long max;
   private long min;

   public Counter(long max, long min)
   {
      this.max = max;
      this.min = min;
      this.value = 0;
   }

   public synchronized void increment()
   {
      while (value >= max)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      value++;
      System.out.println(value + ": " + Thread.currentThread().getName());
      notifyAll();
      
      
   }

   public synchronized void decrement()
   {
      while (value <= min)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      value--;
      System.out.println(value + ": " + Thread.currentThread().getName());
      notifyAll();
      
   }
   
   public long getValue()
   {
      return this.value;
   }
   
   
}
