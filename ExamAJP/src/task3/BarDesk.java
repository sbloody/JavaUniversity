package task3;
public class BarDesk implements IBarDesk
{
   private int fullGlass;
   private int emptyGlass;
   
   public BarDesk()
   {
      this.fullGlass=50;
      this.emptyGlass=0;
   }
   @Override
   public synchronized void takeFullGlasses()
   {
      while(fullGlass<=0)
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
      fullGlass--;
      System.out.println(Thread.currentThread().getName()+" has taken a full glass, full glasses left: "+ fullGlass);
      notifyAll();
      
   }

   @Override
   public synchronized void placeEmptyGlasses()
   {
     emptyGlass++;
     System.out.println("An empty glass has been placed");
     notifyAll();
      
   }

   @Override
   public synchronized void takeEmptyGlasses()
   {
      while(emptyGlass<=0)
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
      emptyGlass--;
      System.out.println(Thread.currentThread().getName()+" takes an empty glasses, empty glasses left: "+ emptyGlass);
      notifyAll();
      
   }

   @Override
   public synchronized void placeFullGlasses()
   {
      fullGlass++;
      System.out.println("A full glass has been placed");
      notifyAll();
      
   }

}
