public class ParkingPlace
{
   private int car;
   private int place;
   private int max;

   public ParkingPlace(int car, int max)
   {
      this.car = car;
      this.place = 0;
      this.max = max;
   }

   public synchronized void arrive()
   {
      while (place >= max)
      {
         System.out.println("There are no free places driver is waiting! "
               + Thread.currentThread().getName());
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {

         }
      }

      System.out.println(Thread.currentThread().getName() + " Parked in!");
      place += car;

      System.out.println("Cars in parking: " + place);
      notifyAll();
   }

   public synchronized void leave()
   {
      while (place <= 0)
      {
         System.out.println("There are no cars in the parking! ");
         try
         {
            wait();

         }
         catch (InterruptedException e)
         {

         }

      }
      place--;
      System.out.println("car left: " + Thread.currentThread().getName());
      System.out.println("free spaces left: " + freePlaces());
      notifyAll();
   }

   public synchronized int freePlaces()
   {

      return max - place;

   }

}
