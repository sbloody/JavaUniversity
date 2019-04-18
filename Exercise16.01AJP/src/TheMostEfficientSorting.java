import java.util.Arrays;

public class TheMostEfficientSorting
{

   private static void quickSort(int[] array, int from, int to)
   {
      int midIndex = (from + to) / 2;
      if (to <= from)
      {
         return; // done
      }
      swop(array, from, midIndex); // set pivot first
      int indexOfPivot = divide(array, from, to);

      if (indexOfPivot < 16)
      {
         insertionSort(array);
      }
      else
      {
         countingSort3(array, from, to);
      }

   }
   
   public static void main(String[] args)
   {
      int[] array = { 25, 2, 45, 20, 56, 24, 52, 56, 99, 53, 12 };

      quickSort(array, 0, array.length - 1);
      for (int i = 0; i < array.length; i++)
      {
         System.out.print(array[i] + " ");
      }

   }
   
   private static int divide(int[] array, int from, int to)
   {
      int pivot = array[from];
      int indexOfPivot = 0;
      int indexOfCompared = to;

      for (int i = 0; i < array.length; i++)
      {
         if (indexOfPivot < indexOfCompared)
         {
            if (pivot > array[indexOfCompared])
            {
               swop(array, indexOfPivot, indexOfCompared);
               int temp = indexOfPivot;
               indexOfPivot = indexOfCompared;
               indexOfCompared = temp;
               indexOfCompared++;
            }
            else
            {
               indexOfCompared--;
            }
         }
         else
         {
            if (pivot < array[indexOfCompared])
            {
               swop(array, indexOfPivot, indexOfCompared);
               int temp = indexOfPivot;
               indexOfPivot = indexOfCompared;
               indexOfCompared = temp;
               indexOfCompared--;
            }
            else
            {
               indexOfCompared++;
            }
         }
      }
      return indexOfPivot;
   }

   private static void swop(int[] array, int index, int indexOfMin)
   {

      int temp = array[index];
      array[index] = array[indexOfMin];
      array[indexOfMin] = temp;
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

      for (int i1 = i; i1 > 0; i1--)
      {
         if (array[i1] < array[i1 - 1])
         {
            swop(array, i1, i1 - 1);
         }
         else
         {
            break;
         }
      }
   }

   public static void countingSort3(int[] array, int small, int large)
   {

      int[] countArray = new int[large - small + 1];
      System.out.println(Arrays.toString(array));
      for (int i = 0; i < array.length; i++)
      {

         countArray[array[i] - small]++;
      }
      System.out.println(Arrays.toString(countArray));

      int sum = 0;

      for (int i = 0; i < countArray.length; i++)
      {
         sum += countArray[i];
         countArray[i] = sum;

      }
      System.out.println(Arrays.toString(countArray));

   }
}
