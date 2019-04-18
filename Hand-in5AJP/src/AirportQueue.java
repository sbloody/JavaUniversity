public class AirportQueue<T> implements PassengerQueue
{
   private LinkedQueue<Passenger> US;
   private LinkedQueue<Passenger> NonUS;
   private QueueADT<Passenger> arrivals;

   public AirportQueue()
   {
       this.US = new LinkedQueue<Passenger>();
       this.NonUS=new LinkedQueue<Passenger>();
      this.arrivals = new LinkedQueue<Passenger>();
      

   }

   @Override
   public synchronized void putPassengerInQueue(Passenger p)
   {
    
      arrivals.enqueue(p);
      notifyAll();
   }

   @Override
   public synchronized Passenger getNextPassenger()
   {

      while (arrivals.isEmpty())
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
      Passenger p = arrivals.dequeue();
      notifyAll();
      return p;
   }
   
   public synchronized Passenger getNextPassengerUS()
   {

      while (US.isEmpty())
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
      Passenger p = US.dequeue();
      notifyAll();
      return p;
   }
   
   public synchronized Passenger getNextPassengerNonUS()
   {

      while (NonUS.isEmpty())
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
      Passenger p = NonUS.dequeue();
      notifyAll();
      return p;
   }

   public synchronized void setUS(LinkedQueue<Passenger> US)
   
   {
      this.US=US;
   }
   
   public synchronized void setNonUS(LinkedQueue<Passenger> NonUS)
   {
      this.NonUS=NonUS;
   }
   
   public synchronized LinkedQueue<Passenger> getUS()
   {
      return US;
   }
   
   public synchronized LinkedQueue<Passenger> getNonUS()
   {
      return NonUS;
   }
}
