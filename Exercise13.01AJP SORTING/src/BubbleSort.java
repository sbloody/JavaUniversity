public class BubbleSort
{
   public static void bubbleSort(int[] array)
   {
      int endIndex = array.length - 1;
      boolean swops;
      do
      {
         swops = bubbleSortPass(array, endIndex);
         endIndex--;
      }
      while (swops);
   }

   private static boolean bubbleSortPass(int[] array, int endIndex)
   {
      boolean temp = false;
      for (int i = 0; i < endIndex; i++)
      {
         if (array[i] > array[i + 1])
         {
            swop(array, i + 1, i);
            temp = true;
         }
      }
      return temp;
   }

   private static void swop(int[] array, int i, int indexOfMin)
   {
      int temp = array[i];
      array[i] = array[indexOfMin];
      array[indexOfMin] = temp;
   }

   
}