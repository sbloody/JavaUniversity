public class BakeryShopSimulator
{
   private static final int NO_CUSTOMERS = 10;
   private static final int NO_CLERKS = 2;

   public static void main(String[] args)
   {
      TakeANumber dispenser = new NumberDispenser();

      for (int i = 1; i <= NO_CLERKS; i++)
      {
         new Thread(new Clerk(dispenser), "Clerk" + i).start();
      }

      for (int i = 1; i <= NO_CUSTOMERS; i++)
      {
         new Thread(new Customer(dispenser), "Customer" + i).start();
      }
   }
}