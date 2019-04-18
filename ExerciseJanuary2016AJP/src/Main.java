
public class Main
{

   public static void main(String[] args)
   {
      SuperMarket market=new SuperMarket();
      Cashier cashier=new Cashier(market);
      Customer customer=new Customer(market);
      Customer customer1=new Customer(market);
      Customer customer2=new Customer(market);
      Customer customer3=new Customer(market);
      Customer customer4=new Customer(market);
      Thread t1=new Thread(cashier,"Cashier ");
      Thread t2=new Thread(customer, "Customer 1");
      Thread t3=new Thread(customer1, "Customer 2");
      Thread t4=new Thread(customer2, "Customer 3");
      Thread t5=new Thread(customer3, "Customer 4");
      Thread t6=new Thread(customer4, "Customer 5");
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t5.start();
      t6.start();
      
      
      

   }

}
