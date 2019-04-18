public class fibonaciFormula
{
   public static int fibonaciFormulaOne(int n)
   {
      if (n == 1 || n == 2)
         return 1;
      return fibonaciFormulaOne(n - 1) + fibonaciFormulaOne(n - 2);

   }

   public static int fibonaciIterative(int n)
   {
      int f1 = 0;
      int f2 = 1;
      int f3 = 1;
      if (n == 1 || n == 2)
         return 1;
      for (int i = 0; i < n; i++)
      {
         f1 = f2;
         f2 = f3; 
         f3 = f1 + f2;

      }
      return f1;
   }

   public static int fibonaciFormulaTwo(double n)
   {
      if (n == 1 || n == 2)
         return 1;
      if (n % 2 == 0)
         return (int) Math.pow(fibonaciFormulaTwo((n / 2) + 1), 2)
               - (int) Math.pow(fibonaciFormulaTwo((n / 2) - 1), 2);

      return (int) Math.pow(fibonaciFormulaTwo((n + 1) / 2), 2)
            + (int) Math.pow(fibonaciFormulaTwo((n - 1) / 2), 2);
   }

   public static void main(String[] args)
   {
      // System.out.println(fibonaciFormulaOne(7));
      System.out.println(fibonaciFormulaTwo(8));
      System.out.println(fibonaciIterative(8));
   }
}
