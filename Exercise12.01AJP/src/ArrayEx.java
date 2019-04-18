import java.util.Arrays;

public class ArrayEx
{
   public static void main(String[] args)
   {
      int array[] = { 2, 3, 4, 5, 6, 6, 7 };

      System.out.println(hasDuplicates(array));
      System.out.println("The number of different elements is: "
            + countDifferentElements(array));
      System.out.println(Arrays.toString(removeDuplicates(array)));
   }

   public static boolean hasDuplicates(int[] array)
   {
      boolean duplicates = false;
      for (int i = 0; i < array.length - 1; i++)
      {
         if (array[i] == array[i + 1])
            duplicates = true;
      }
      return duplicates;

   }

   public static int countDifferentElements(int[] array)
   {
      if (!hasDuplicates(array))
         return array.length;
      int count = 1;
      for (int i = 0; i < array.length - 1; i++)
      {
         if (array[i] != array[i + 1])
         {
            count++;
         }
      }
      return count;

   }

   public static int[] removeDuplicates(int[] array)
   {
      Arrays.sort(array);
      if (hasDuplicates(array))
      {
         int numberOfDifElements = countDifferentElements(array);
         int[] duplicated = new int[numberOfDifElements];
         int j = 0;
         for (int i = 0; i < array.length - 1; i++, j++)
         {
            if (array[i] != array[i + 1])

               duplicated[j] = array[i];

         }
         return duplicated;
      }
      return array;
   }
}
