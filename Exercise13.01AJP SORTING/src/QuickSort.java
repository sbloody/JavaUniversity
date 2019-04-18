import java.util.Arrays;

public class QuickSort
{

   public static void main(String[] args)
   {
      int[] array = {25, 2, 45, 20, 56, 24, 52, 56, 99, 53, 12};
      int indexOfPivot = divide(array, 0, array.length-1);
      System.out.println(indexOfPivot);
      quickSort(array,0,array.length-1);
      System.out.println(Arrays.toString(array));
   }

   private static int divide(int[] array, int from, int to)
   {

      int tmp;
      int pivot = array[(from + to) / 2];

      while (from <= to)
      {
         while (array[from] < pivot)
            from++;
         while (array[to] > pivot)
            to--;
         if (from <= to)
         {
            tmp = array[from];
            array[from] = array[to];
            array[to] = tmp;
            from++;
            to--;
         }
      }
      

      return from;
   }

   public static void quickSort(int array[], int from, int to)
   {
      int index = divide(array, from, to);
      if (from < index - 1)
         quickSort(array, from, index - 1);
      if (index < to)
         quickSort(array, index, to);
      if(array.length<16)
         InsertionSort.insertionSort(array);
   }

}
