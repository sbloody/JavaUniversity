package utility.math;

import java.util.ArrayList;

public class NaturalNumber
{
   private int value;

   public NaturalNumber(int value) throws IllegalArgumentException
   {
      if (value < 1)
         throw new IllegalArgumentException("Illegal Argument");
      this.value = value;
   }

   public void setValue(int value) throws IllegalArgumentException
   {
      if (value < 1)
         throw new IllegalArgumentException("Illegal Argument");
      this.value = value;
   }

   public int getValue()
   {
      return value;
   }

   public int[] getPrimeFactors()
   {
      int value = this.value;
      ArrayList<Integer> factors = new ArrayList<>();
      int i = 2;
      while (value > 1)
      {
         while (value % i == 0)
         {
            factors.add(i);
            value /= i;
         }
         i++;
      }
      return convertToIntArray(factors);
   }

   public static int[] convertToIntArray(ArrayList<Integer> list)
   {
      int[] array = new int[list.size()];
      for (int i = 0; i < list.size(); i++)
      {
         array[i] = list.get(i);
      }
      return array;
   }

   public boolean isPrime()
   {
      if (value > 1)
      {
         if ((value * value - 1) % 24 == 0)
            return true;

      }
      return false;
   }

   public String toString()
   {
      return "Value: " + value;
   }

   public int[] getProperDivisors() throws IllegalArgumentException
   {
      int value = this.value;
      ArrayList<Integer> divisors = new ArrayList<>();
      if (value < 1)
         throw new IllegalArgumentException("The number has to be positive");
      if (value == 1)
         return convertToIntArray(divisors);
      divisors.add(1);
      for (int i = 2; i < value; i++)
      {
         if (value % i == 0)
            divisors.add(i);

      }
      return convertToIntArray(divisors);
   }

   public boolean isPerfectNumber()
   {
      int value = this.value;
      int[] arr = getProperDivisors();
      int sum = 0;
      if (value > 1)
      {
         for (int i = 0; i < arr.length; i++)
         {
            sum += arr[i];
         }
         if (sum == value)
            return true;
      }
      return false;
   }

   public boolean isPrimePower()
   {

      int[] primeFactors = getPrimeFactors();
      if (isPrime())
      {
         return true;
      }

      for (int i = 0; i < primeFactors.length - 1; i++)
      {

         if (primeFactors[i] != primeFactors[++i])
         {
            return false;
         }

      }
      return true;
   }

   // public boolean isPrimePower()
   // {
   //
   // if (value > 1)
   // {
   // if (isPrime())
   // ;
   // int[] arr = getPrimeFactors();
   // for (int i = 0; i < arr.length; i++)
   // {
   // while (arr[i] == arr[i++])
   // {
   // return true;
   // }
   //
   // }
   //
   // }
   // return false;
   // }
}
