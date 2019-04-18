public class Display implements Runnable
{

   private BarberShop barberShop;

   public Display(BarberShop barberShop)
   {
      this.barberShop = barberShop;
   }

   @Override
   public void run()
   {
      while(true)
      {
         int free = barberShop.getFreeSpaces();
         System.out.println("Free spaces: " + free);
      }
   }

}
