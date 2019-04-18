public class Camper implements Runnable
{

   private PancakeCooking pancakeCooking;

   public Camper(PancakeCooking pancakeCooking)
   {
      this.pancakeCooking = pancakeCooking;
   }

   @Override
   public void run()
   {

      for (int i = 0; i < 8; i++)
      {
         this.pancakeCooking.takeBakingPlate();
         this.pancakeCooking.pourBatterOnBakingPlate();
         makeAPancake();
         this.pancakeCooking.putBackBakingPlate();
         eat();

      }

   }

   private void makeAPancake()
   {
      System.out.println(Thread.currentThread().getName()
            + " is making a pancake.");
      try
      {
         Thread.sleep(3000);
      }
      catch (InterruptedException e)
      {

      }
   }

   private void eat()
   {
      System.out.println(Thread.currentThread().getName() + " is eating.");
      try
      {
         Thread.sleep(4000);
      }
      catch (InterruptedException e)
      {

      }
   }
}
