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

   public String toString()
   {
      return "The natural number is: " + this.value;
   }

   public String getValueInBase(int base)
   {
      return getValueInBase(value, base);
   }

   private String getValueInBase(int value, int base)
         throws IllegalArgumentException
   {
      if (value <= 0)
         return "";
      else
      {
         if (base < 2)

            throw new IllegalArgumentException();
         if (base <= 10)
            return getValueInBase(value / base, base) + value % base;
         if (base > 10 && base <= 36)
            return (getValueInBase(value / base, base) + Integer
                  .toHexString(value % base)).toUpperCase();
         else
            return getValueInBase(value / base, base) + "." + value % base;
      }
   }
}