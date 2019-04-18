public class Car   implements Runnable
{
   int updates;
   private ParkingPlace car;

   
   
   public Car(ParkingPlace car, int updates)
   {
      this.car = car;
      this.updates = updates;
   }

   @Override
   public void run()
   {
      for (int i = 0; i < updates; i++)
      {
         car.arrive();
         try
         {
              Thread.sleep(3000);
           }
           catch (InterruptedException e){
              e.printStackTrace();
           }
         car.leave();
         try
         {
              Thread.sleep(3000);
           }
           catch (InterruptedException e){
              e.printStackTrace();
           }
      }
   }
}
