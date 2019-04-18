public class BurgerBarCustomer implements Runnable
{
   private int burgersToEat;
   private String name;
   private BurgerBar burgerBar;

   public BurgerBarCustomer(String name, BurgerBar burgerBar, int burgersToEat)
   {
      this.name = name;
      this.burgerBar = burgerBar;
      this.burgersToEat=burgersToEat;

   }

   private void timeForMakingTheBurger()
   {
      try
      {
         Thread.sleep(500);
      }
      catch (InterruptedException e)
      {
         // ...
      }
   }

   @Override
   public void run()
   {
      for(int i=0;i<burgersToEat;i++)
      {
         burgerBar.makeBurger(name);
         timeForMakingTheBurger();
      }

   }

}
