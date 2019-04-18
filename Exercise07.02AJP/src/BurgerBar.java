public class BurgerBar
{
   private int numberOfBurgers;
   private int maxNumberOfBurgers;

   public BurgerBar(int maxNumberOfBurgers)
   {
      this.maxNumberOfBurgers = maxNumberOfBurgers;
      this.numberOfBurgers = 0;
   }

   public synchronized void makeBurger(String employeeName)
   {
      while (numberOfBurgers >= maxNumberOfBurgers)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      System.out.println(employeeName+ " is ready to make a burger (" +
            numberOfBurgers + " now)");
      numberOfBurgers++;

      notifyAll();

   }

   public synchronized void eatBurger(String who)
   {
      while (numberOfBurgers <= 0)
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      numberOfBurgers--;
      System.out.println(who + " is ready to eat a burger (" +
            numberOfBurgers + " left)");

      notifyAll();
   }
   
   public int getNumberOfBurgers()
   {
      return this.numberOfBurgers;
   }
}
