
public class Fork
{
   private int id;
   private boolean isTaken;
   
   public Fork(int id)
   {
      this.id = id;
      this.isTaken = false;
   }
   public synchronized void getFork()
   {
      while(isTaken)
      {
         try
         {
            System.out.println(Thread.currentThread().getName() +  "Is waiting for fork : " + id);
            wait();
         }
         catch (InterruptedException e)
         {
             e.printStackTrace();
         }
      }
      isTaken = true;
      System.out.println(Thread.currentThread().getName() +  "Picked up a fork : " + id);
      notifyAll();
      
   }

   public synchronized void putbackFork()
   {
      isTaken = false;
      System.out.println(Thread.currentThread().getName() +  "The fork is returned : " + id);
      notifyAll();
   }

}
