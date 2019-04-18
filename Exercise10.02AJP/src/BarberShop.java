public class BarberShop
{

   private QueueADT<Customer> customerQueue;
   private int emptyChairs;

   public BarberShop(int maxSpace)
   {
      this.emptyChairs = 0;
      this.customerQueue = new BoundedArrayQueue<Customer>(maxSpace);

      for (int i = 0; i < maxSpace; i++)
      {
         customerQueue.enqueue(new Customer(i));
      }
   }

   public synchronized void wantsToBeCut(Customer customer)
   {
      while (emptyChairs < 0)
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
      emptyChairs--;
      System.out.println("-->" + Thread.currentThread().getName()
            + " is waiting to be cut " + "empty: "+emptyChairs);
      notifyAll();

   }

   public synchronized Customer cuttingTheNext()
   {
      while (customerQueue.isEmpty())
      {
         try
         {
            System.out.println("No customers: ");
            wait();
         }
         catch (InterruptedException e)
         {
            e.printStackTrace();
         }
      }
      Customer cust=customerQueue.dequeue();
      emptyChairs++;
      notifyAll();

      return cust;
   }

   public synchronized int getFreeSpaces()
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
      return emptyChairs;
   }
}
