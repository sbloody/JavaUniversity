
public class BurgerBarMain
{
   
   public static void main(String[] args)
   {
   BurgerBar bar=new BurgerBar(20);
   BurgerBarCustomer c1=new BurgerBarCustomer("Mario", bar, 10);
   BurgerBarCustomer c2=new BurgerBarCustomer("Dani", bar,20);
   BurgerBarCustomer c3=new BurgerBarCustomer("Angel", bar,30);
   BurgerBarCustomer c4=new BurgerBarCustomer("George", bar,40);
   BurgerBarCustomer c5=new BurgerBarCustomer("Edi", bar,50);
   BurgerBarEmployee e1=new BurgerBarEmployee("Alex", bar);
   BurgerBarEmployee e2=new BurgerBarEmployee("Peter", bar);
   Thread threadc1=new Thread(c1, "Customer1");
   Thread threadc2=new Thread(c2, "Customer2");
   Thread threadc3=new Thread(c3, "Customer3");
   Thread threadc4=new Thread(c4, "Customer4");
   Thread threadc5=new Thread(c5 ,"Customer5");
   Thread threade1=new Thread(e1, "Employee1");
   Thread threade2=new Thread(e2, "Employee2");
   threadc1.start();
   threadc2.start();
   threadc3.start();
   threadc4.start();
   threadc5.start();
   threade1.start();
   threade2.start();
   }
}
