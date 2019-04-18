public class HandIn
{

   public static void main(String[] args)
   {
      Function polynom = new Polynomial();
      System.out.println(bisection(polynom, 1, 5, 0.00001));
      System.out.println(intDivision(16, 3));
      System.out.println(intDivisionIterative(20, 3));

   }

   public static double bisection(Function fct, double a, double b,
         double epsilon)
   {
      while (Math.abs(b - a) > epsilon)
      {
         double midpoint = (b + a) / 2;
         if ((fct.f(a) * fct.f(midpoint)) > 0)
         {
            a = midpoint;
         }
         else
            b = midpoint;

      }
      return (b + a) / 2;

   }

   public static int intDivision(int m, int n)
   {
      if (m < n)
         return 0;
     
      return 1 + intDivision(m - n, n);

   }

   public static int intDivisionIterative(int m, int n)
   {
      if (m < n)
         return 0;
      int count = 0;
      while ((m - n) >= 0)
      {
         m = m - n;
         count++;
      }
      return count;
   }

}
