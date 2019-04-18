
public class BarberShopTest
{
   public static void main(String[] args)
   {
      BarberShop barber = new BarberShop(5);
      
      Thread display = new Thread(new Display(barber), "Display");
      display.start();
      
      Thread[] cuts = new Thread[10];
      for (int i = 0; i < cuts.length; i++)
      {
         CustomerArrivals cut = new CustomerArrivals(barber);
         cuts[i] = new Thread(cut, "Clients" + i);
         cuts[i].start();
      }
   }
}
