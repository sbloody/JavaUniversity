
public class Philosopher implements Runnable
{
   private Fork rightFork;
   private Fork leftFork;
   private int id;
   
   public Philosopher(int id, Fork leftFork, Fork rightFork)
   {
      this.id = id;
      this.leftFork = leftFork;
      this.rightFork = rightFork;
   }
   
   @Override
   public void run()
   {
      while (true)
      {
      action("THINK", 10000, 10000);
      rightFork.getFork();
      leftFork.getFork();
      action("EAT", 5000, 5000);
      rightFork.putbackFork();
      leftFork.putbackFork();
      }

   }

   private void action(String string, int min, int max)
   {
      int time =  (int) (Math.random() * (max - min) + min);
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
