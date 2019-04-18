
public class Test
{

   public static void main(String[] args)
   {
      ParkingPlace counter = new ParkingPlace(1, 4);
      Car inc1 = new Car(counter, 200);
      Car inc2 = new Car(counter, 200);
      Car inc3 = new Car(counter, 200);
      Car inc4 = new Car(counter, 200);
      Car inc5 = new Car(counter, 200);
      Car inc6 = new Car(counter, 200);
          Thread threadInc1 = new Thread(inc1, "car1");
      Thread threadInc2 = new Thread(inc2, "car2");
      Thread threadInc3 = new Thread(inc1, "car3");
      Thread threadInc4 = new Thread(inc2, "car4");
      Thread threadInc6 = new Thread(inc1, "car6");
      Thread threadInc5 = new Thread(inc2, "car5");
      threadInc1.start();
      threadInc2.start();
      threadInc3.start();
      threadInc4.start();
      threadInc6.start();
      threadInc5.start();
   }

}
