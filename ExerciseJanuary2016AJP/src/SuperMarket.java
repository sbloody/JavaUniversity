public class SuperMarket implements ISuperMarket
{

   private int customer;
   private boolean served;
   private int notServed;

   public SuperMarket()
   {
      this.customer = 0;
//      this.served = false;
      this.served=true;
      this.notServed=0;
      
   }

   @Override
   public synchronized void enterWaitingLine()
   {
      while (!served)
      {
         try
         {
            
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      customer++;
      System.out.println(Thread.currentThread().getName()
            + " arrives and enters the waiting line, number of customers: "
            + customer);
      notifyAll();

   }

   @Override
   public synchronized void startNextServing()
   {
      while (customer <= 0)
      {
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      System.out.println(Thread.currentThread().getName()
            + " serves customer " + customer);
//      customer--;
      served=true;
      notifyAll();

   }

   @Override
   public synchronized void serviceFinished()
   {
      
      customer--;
      served = false;
      notifyAll();

   }

}
