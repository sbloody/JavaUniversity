public class Task1
{
   public static void main(String[] args)
   {

      System.out.println(power(5, 3));
      System.out.println(powerIterative(25, 2));
      System.out.println(powerEfficient(40, 2));
   }

   public static long power(long x, int n)
   {
      if (n == 0)
         return 1;
      if (n > 0)
      {
         return x * power(x, n - 1);
      }
      else
         return -1;

   }

   public static long powerIterative(long x, int n)
   {
      if (n == 0)
         return 1;
      if (n < 0)
         return -1;
      else
         return (long) Math.pow(x, n);

   }
   
   public static long powerEfficient(long x, int n)
   {
      if (n==0)
            return 1;
      if(n<0)
         return -1;
      if(n%2==0)
         return (long)Math.pow(x, n/2)*(long)Math.pow(x, n/2);
      else
         return x*powerEfficient(x, n-1);
      
      
   }
}
