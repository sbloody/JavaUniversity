package utility.math;

public class PowerSolution
{
   public static long powerRecursive(long x, int n) throws IllegalArgumentException
   {
      if(n<0)throw new IllegalArgumentException("Power argument should be positive");
      if(n==0)
         return 1;
      return x*powerRecursive(x,n-1);
   }
   
   public static long powerIterative(long x,int n) throws IllegalArgumentException
   {
      if(n<0)throw new IllegalArgumentException("Power argument should be positive");
      if(n==0)
         return 1;
      long total=1;
      for(int i=0;i<n;i++ )
      {
        total*=x;
      }
      return total;
   }
   
   public static long powerRecursiveV2(long x, int n) throws IllegalArgumentException
   {
      if(n<0)throw new IllegalArgumentException("Power argument should be positive");
      if(n==0)
         return 1;
      if(n%2==0)
      {
         long a=powerRecursiveV2(x,(n/2));
         return a*a;
      }
      else 
      {
         long a=powerRecursiveV2(x,(n-1));
         return x*a;
      }
      
      
   }
}
