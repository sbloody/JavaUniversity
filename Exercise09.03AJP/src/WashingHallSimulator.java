public class WashingHallSimulator
{

   public static void main(String[] args)
   {
      WashingHall washingHall = new WashingHall(5);

      Thread display = new Thread(new Display(washingHall));
      display.start();

      Thread[] cars = new Thread[10];
      for (int i = 0; i < cars.length; i++)
      {
         Car car = new Car(washingHall);
         cars[i] = new Thread(car, "Car" + i);
         cars[i].start();
      }

   }

}
