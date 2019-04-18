
public class DiningPhilosopherSimulation
{
   public static void main(String[] args)
   {
      Fork[] fork = new Fork[5];
      for (int i = 0; i < fork.length; i++)
      {
         fork[i] = new Fork(i);
      }
      
      Thread[] philosophers = new Thread[fork.length];
      for (int i = 0; i < philosophers.length; i++)
      {
         Philosopher philospher = new Philosopher(i, fork[i], fork[(i + 1)%fork.length]);
         philosophers[i] = new Thread(philospher, "Phil" + i);
         philosophers[i].start();
      }
   }
}
