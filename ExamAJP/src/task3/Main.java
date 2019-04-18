package task3;

public class Main
{

   public static void main(String[] args)
   {
      BarDesk bar= new BarDesk();
      Customer cust1=new Customer(bar);
      Customer cust2=new Customer(bar);
      Customer cust3=new Customer(bar);
      Customer cust4=new Customer(bar);
      Customer cust5=new Customer(bar);
      Customer cust6=new Customer(bar);
      Bartender tend1=new Bartender(bar);
      Bartender tend2=new Bartender(bar);
      Bartender tend3=new Bartender(bar);
      Bartender tend4=new Bartender(bar);
      Bartender tend5=new Bartender(bar);
      Thread t1=new Thread(cust1,"Customer 1");
      Thread t2=new Thread(cust2,"Customer 2");
      Thread t3=new Thread(cust3,"Customer 3");
      Thread t4=new Thread(cust4,"Customer 4");
      Thread t5=new Thread(cust5,"Customer 5");
      Thread t6=new Thread(cust6,"Customer 6");
      Thread t7=new Thread(tend1,"Bartender 1");
      Thread t8=new Thread(tend2,"Bartender 2");
      Thread t9=new Thread(tend3,"Bartender 3");
      Thread t10=new Thread(tend4,"Bartender 4");
      Thread t11=new Thread(tend5,"Bartender 5");
      t1.start();
      t2.start();
      t3.start();
      t4.start();
      t5.start();
      t6.start();
      t7.start();
      t8.start();
      t9.start();
      t10.start();
      t11.start();
      

   }

}
