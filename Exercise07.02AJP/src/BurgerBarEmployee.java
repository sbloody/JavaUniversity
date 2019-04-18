
public class BurgerBarEmployee implements Runnable
{
   private String name;
   private BurgerBar burgerBar;
   
   public BurgerBarEmployee(String name, BurgerBar burgerBar)
   {
      this.name=name;
      this.burgerBar=burgerBar;
   }
   
   private void timeForEatingTheBurger()
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
      while(true)
      {
         burgerBar.eatBurger(name);
         timeForEatingTheBurger();
      }
      
   }
   
    
}
