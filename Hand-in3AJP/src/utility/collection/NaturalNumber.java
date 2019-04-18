package utility.collection;

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

   public String getValueInBase(int base)
   {
      if(base==2)
      {
        return "0b" + getValueInBase(value, base);
      }
      if(base ==16)
       {
        return "0x" + getValueInBase(value, base);
       }
      if( base !=10)
     {
      return  getValueInBase(value,base)+" [base "+base+"]"; 
     }
     return getValueInBase(value, base);
   }

   private static String getValueInBase(int value, int base)
         throws IllegalArgumentException
   {
      if (value <= 0)
         return "";
      else
      {
         if (base < 2)

            throw new IllegalArgumentException();
         
         if (base <= 10)
         { 
            
            return getValueInBase(value / base, base) + value % base;
         }
         if (base > 10 && base <= 36)
         {
            
            return (getValueInBase(value / base, base) + Integer
                  .toHexString(value % base)).toUpperCase();
         }
         else  
         {
            if ((value / base) == 0)
               return getValueInBase(value / base, base) + value % base;
            return getValueInBase(value / base, base) + "." + value % base;
         }
      }
   }

   public int getDigitSum()
   {
      return getDigitSum(value);
   }

   private static int getDigitSum(int value)
   {
      int total=0;
      total+=value%10;
      value/=10;
      if (value == 0)
         return total;
     
      return getDigitSum(value)+total;

   }

   public int getDigitalRoot()
   {
      return getDigitalRoot(value);
   }

   private static int getDigitalRoot(int value)
   {
      if (value < 0)
         throw new IllegalArgumentException("Value should be positive");
      if (value > 1)
         return getDigitalRoot(getDigitSum(getDigitSum(value)));
      else
         return 0;
   }

   public static void main(String[] args)
   {
      System.out.println(getDigitSum(84001));
      System.out.println(getDigitalRoot(65536));
   }
}