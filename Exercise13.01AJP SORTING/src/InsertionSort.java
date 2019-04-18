import java.util.Arrays;

public class InsertionSort
{
   public static void main(String[] args)
   {
      int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };
      insertionSort(array);
      System.out.println(Arrays.toString(array));
   }

   public static void insertionSort(int[] array)
   {
      for (int i = 1; i < array.length; i++)
      {
         backwardPass(array, i);
      }
   }

   private static void backwardPass(int[] array, int i)
   {
      int temp = array[i];

      for (int j = i; j > 0; j--)
      {
         if (array[j] < array[j - 1])
         {
            temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
         }
      }

   }
}
