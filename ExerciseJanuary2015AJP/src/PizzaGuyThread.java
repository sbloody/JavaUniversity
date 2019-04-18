
public class PizzaGuyThread implements Runnable
{
   private PizzaMethods guy;
   
   public PizzaGuyThread(PizzaMethods guy)
   {
      this.guy=guy;
   }
   
   public void run()
   {
      while(true)
      {
         guy.receiveAPizzaOrder();
         makeAPizza();
         guy.deliverAPizza();
      }
   }
   
   private void makeAPizza()
   {
      System.out.println(Thread.currentThread().getName()
            + " is making a pizza.");
      try
      {
         Thread.sleep(3000);
      }
      catch (InterruptedException e)
      {

      }
   }
}
