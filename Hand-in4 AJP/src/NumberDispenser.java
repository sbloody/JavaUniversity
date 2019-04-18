
public class NumberDispenser implements TakeANumber
{

   private int nextNumberToTake;
   private int nextNumberToServe;
   
   public NumberDispenser()
   {
      this.nextNumberToServe=1;
      this.nextNumberToTake=1;
   }
   
   @Override
   public synchronized void takeNextNumber() 
   {
      int number=nextNumberToTake;
      nextNumberToTake++;
      while(number>nextNumberToServe)
      {
         try
         {
            System.out.println("--|" + Thread.currentThread().getName()
                  + " with number " + number
                  + " is waiting (next to serve = " + nextNumberToServe + ")");
            wait();
         }
         catch (InterruptedException e)
         {
         }
      }
      System.out.println("-->" + Thread.currentThread().getName()
      + " with number " + number
      + " is ready to be served");
      notifyAll();
   }
   

   @Override
   public synchronized int nextCustomer()
   {
      while(nextNumberToServe>=nextNumberToTake)
      {
         try
         {
            System.out.println("--|" + Thread.currentThread().getName()
                  + " is waiting (next to take = " + nextNumberToTake + ")");
            wait();
         }
         catch (InterruptedException e)
         {
         }
      }
      System.out.println("-->" + Thread.currentThread().getName()
            + " is serving customer with number " + nextNumberToServe);
      nextNumberToServe++;
      notifyAll();
      return nextNumberToServe - 1;
      }  
}
