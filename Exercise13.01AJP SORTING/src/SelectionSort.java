import java.util.Arrays;

public class SelectionSort
{

   public static void main(String[] args)
   {
      int[] array = { 8, 5, 2, 6, 9, 3, 1, 4, 0, 7 };
      System.out.println(indexOfMin(array, 0));
      selectionSort(array);
      System.out.println(Arrays.toString(array));

   }

   public static void selectionSort(int[] array)
   {
      for (int i = 0; i < array.length - 1; i++)
      {
         int indexOfMin = indexOfMin(array, i);
         swop(array, i, indexOfMin);

      }

   }

   private static void swop(int[] array, int i, int indexOfMin)
   {
      int tmp = array[indexOfMin];
      array[indexOfMin] = array[i];
      array[i] = tmp;

   }

   private static int indexOfMin(int[] array, int startIndex)
   {
      int min = startIndex;
      for (int i = startIndex + 1; i < array.length; i++)
      {
         if (array[i] < array[min])
         {
            min = i;
         }

      }
      return min;
   }

}
