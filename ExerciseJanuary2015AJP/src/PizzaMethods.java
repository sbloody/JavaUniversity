public class PizzaMethods implements IPizzaMethods
{
   private int slices;
   private int pizzas;
   private int orders;

   public PizzaMethods()
   {
      this.pizzas = 0;
      this.slices = 0;
      this.orders = 0;
   }

   @Override
   public synchronized void orderAPizza()
   {
      while (slices > 0)
      {
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      orders++;
      System.out.println(Thread.currentThread().getName()
            + " has ordered a pizza");
      notifyAll();

   }

   @Override
   public synchronized void getAPizzaSlice()
   {
      while (slices <= 0)
      {
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      slices--;
      if(slices%8==0)
         pizzas--;
      System.out.println(Thread.currentThread().getName()
            + " has gotten a pizza slice, number of slices left: " + slices);
      notifyAll();
   }

   @Override
   public synchronized void receiveAPizzaOrder()
   {
      while (orders <= 0)
      {
         try
         {
            wait();
         }
         catch (InterruptedException e)
         {
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      System.out.println(Thread.currentThread().getName()
            + " has received a order, orders now: " + orders);
      orders--;
      notifyAll();
   }

   @Override
   public synchronized void deliverAPizza()
   {
      pizzas++;
      slices += 8;
      System.out.println("Pizza has been delivered, now there are " + pizzas
            + " pizzas and " + slices + " slices");

   }

}
