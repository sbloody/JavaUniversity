
public class Display implements Runnable
{
   private WashingHall washingHall;
   
   public Display(WashingHall washingHall)
   {
      this.washingHall=washingHall;
   }

   @Override
   public void run()
   {
      while(true)
      {
         int free=washingHall.getFreePlaces();
         System.out.println("Free places: "+ free);
      }
      
   }
   
   
}
