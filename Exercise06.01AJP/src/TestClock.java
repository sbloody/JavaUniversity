
public class TestClock
{

   public static void main(String[] args)
   {
      Clock clock = new Clock();
      Show showClock = new Show(clock);
      clock.set(8, 10, 40);
      Update updateClock = new Update(clock);
      Thread showClockThread = new Thread(showClock);
      Thread updateClockThread = new Thread(updateClock);
      showClockThread.start();
      updateClockThread.start();
      System.out.println("MAIN ENDED");

   }
   
}
