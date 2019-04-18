
public class Car implements Runnable
{
   private WashingHall car;
//   private String name;\
   
//   private void timeForWashing()
//   {
//      try
//      {
//         Thread.sleep(2000);
//      }
//      catch (InterruptedException e)
//      {
//         // ...
//      }
//   }

   public Car(WashingHall car)
   {
      this.car=car;
   }
   @Override
   public void run()
   {

      for(int i=0;i<5;i++)
      {
         drive(1000,2000);
         Hall hall=car.enterForWashing();
         wash(500,1000);
         car.leaveWashing(hall);
         
      }
      
   }
   
   private void drive(int min, int max)
   {
      int time= (int) (Math.random()*(max-min)+min);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
   
   private void wash(int min, int max)
   {
      int time= (int) (Math.random()*(max-min)+min);
      try
      {
         Thread.sleep(time);
      }
      catch (InterruptedException e)
      {
         e.printStackTrace();
      }
   }
   
}
